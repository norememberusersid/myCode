package com.market.controller.index;
import com.market.controller.*;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.*;
import com.market.util.*;
import com.market.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("index/pro_detail")
public class IndexProDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ProTypeMapper proTypeMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	CartMapper cartMapper;
	@Autowired
	OrderMsgMapper orderMsgMapper;
	//商品详情页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap,Integer id, HttpServletRequest request) {
		ProMsg proMsg = proMsgMapper.selectByPrimaryKey(id);//查询商品
		if(proMsg==null){
			proMsg = new ProMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		dataDetail.put("model",proMsg);
		//解释商品类型
		ProType pidT = proTypeMapper.selectByPrimaryKey(proMsg.getPid());
		if(pidT==null){
			pidT = new ProType();
		}
		dataDetail.put("pidT",pidT);
		//将多张图片以list形式返回给前端
		List<String> proDetailList = new ArrayList<String>();
		if(proMsg.getProDetail()!=null&&proMsg.getProDetail().trim().equals("")==false){
			String [] proDetailSplit = proMsg.getProDetail().split(";");
			for(String proDetailStr:proDetailSplit){
				if(proDetailStr.trim().equals("")==false){
					proDetailList.add(proDetailStr);
				}
			}
		}
		dataDetail.put("proDetailList",proDetailList);
		modelMap.addAttribute("proMsgDetail",dataDetail);
		return "index/pro_detail";
	}
	//提交订单接口
	@RequestMapping("submitOrderMsg")
	@ResponseBody
	public Object submitOrderMsg(HttpServletRequest request,OrderMsg orderMsg){
		Map<String,Object> rs = new HashMap<String,Object>();
		return addOrderMsg(request,orderMsg);
	}
	public Map<String,Object> addOrderMsg(HttpServletRequest request,OrderMsg orderMsg){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		Map<String,Object> check1  = checkOrderMsg(request,orderMsg);
		if(check1.get("code").toString().equals("0")){
			return check1;
		}
		UserMsg uidT = userMsgMapper.selectByPrimaryKey(orderMsg.getUid());//查询会员
		ProMsg pidT = proMsgMapper.selectByPrimaryKey(orderMsg.getPid());//查询商品
		if(uidT!=null){
			orderMsg.setUrealName(uidT.getRealName());//赋值uidT的姓名
		}
		if(uidT!=null){
			orderMsg.setUcelPhone(uidT.getCelPhone());//赋值uidT的联系电话
		}
		if(uidT!=null){
			orderMsg.setUaddress(uidT.getAddress());//赋值uidT的地址
		}
		if(pidT!=null){
			orderMsg.setPproPrice(pidT.getProPrice());//赋值pidT的价格
		}
		
		Double zk = 1.0;
		String yfAmount = df.format(orderMsg.getOrderNum()*orderMsg.getPproPrice())+"";
		if(uidT.getUserScore()<1000) {
			yfAmount+="(无折扣)";
		}else if(uidT.getUserScore()<2000) {
			zk = 0.9;
			yfAmount+="(9折)";
		}else {
			yfAmount+="(8折)";
			zk = 0.8;
		}
		Double payAmount = orderMsg.getOrderNum()*orderMsg.getPproPrice()*zk;
		orderMsg.setTotalAmount(yfAmount);
		orderMsg.setPayAmount(payAmount);
		
		uidT.setUserScore(uidT.getUserScore()+payAmount.intValue());
		
		
		orderMsg.setOrderNo(sdf3.format(new Date())+RandomCodeUtils.getRandomCode());//随机码(当前时间+6位随机码)
		orderMsg.setUid(login.getId());//登录id
		orderMsg.setOrderStatus(1);//默认待付款,
		orderMsg.setCreateTime(sdf1.format(new Date()));//当前时间格式
		orderMsgMapper.insertSelective(orderMsg);
		rs.put("code",1);
		rs.put("msg","提交订单成功");
		return rs;
	}
	//数据校验
	public Map<String,Object> checkOrderMsg(HttpServletRequest request,OrderMsg orderMsg){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		orderMsg.setUid(login.getId());
		if(orderMsg.getOrderNum()==null){
			rs.put("code",0);
			rs.put("msg","数量为必填属性");
			return rs;
		}
		ProMsg proMsg = proMsgMapper.selectByPrimaryKey(orderMsg.getPid());
		if(proMsg==null){
			rs.put("code",0);
			rs.put("msg","该商品已不存在");
			return rs;
		}
		if(proMsg.getProStockNum()==null||proMsg.getProStockNum().compareTo(orderMsg.getOrderNum())<0){//pro_msg.pro_stock_num小于order_msg.order_num，则不允许提交
			rs.put("code",0);
			rs.put("msg","商品库存数量不足");
			return rs;
		}
		rs.put("code",1);
		rs.put("msg","校验成功");
		return rs;
	}
}
