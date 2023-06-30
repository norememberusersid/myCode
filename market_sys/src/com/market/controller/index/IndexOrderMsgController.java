package com.market.controller.index;
import com.market.controller.*;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.*;
import com.market.util.*;
import com.market.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("index/order_msg")
public class IndexOrderMsgController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	OrderMsgMapper orderMsgMapper;
	@RequestMapping(value = "")
	public Object index(ModelMap modelMap, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("login", login);
		if(login==null||login.getLoginType()!=2){
			modelMap.addAttribute("msg","尚未登录");
			return "index/error";
		}
		//查询所有待付款的订单
		OrderMsgExample orderMsgE = new OrderMsgExample();
		OrderMsgExample.Criteria orderMsgC = orderMsgE.createCriteria();
		orderMsgC.andUidEqualTo(login.getId());
		orderMsgC.andOrderStatusEqualTo(1);
		List<OrderMsg> orderMsgList = orderMsgMapper.selectByExample(orderMsgE);
		List<Map<String,Object>> orderMsgList2 = new ArrayList<Map<String,Object>>();
		Double totalAmount=0.0;//总金额计算
		String oids = "";
		for(OrderMsg orderMsg:orderMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",orderMsg.getId());
			oids+=orderMsg.getId()+",";
			map.put("totalAmount", df.format(orderMsg.getPayAmount()));
			totalAmount+=orderMsg.getPayAmount();
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(orderMsg.getPid());
			map.put("proImg",proMsg.getProImg());
			map.put("proTitle",proMsg.getProTitle());
			map.put("pproPrice",orderMsg.getPproPrice());
			map.put("orderNum",orderMsg.getOrderNum());
			map.put("proMsgId",orderMsg.getPid());
			orderMsgList2.add(map);
		}
		modelMap.addAttribute("orderMsgList", orderMsgList2);
		modelMap.addAttribute("totalAmount", df.format(totalAmount));
		modelMap.addAttribute("oids",oids);
		return "index/order_msg_pay";
	}
	//模拟支付页面显示
	@RequestMapping(value = "goPay")
	public Object goPay(ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("login", login);
		if(login==null||login.getLoginType()!=2){
			modelMap.addAttribute("msg","尚未登录");
			return "index/error";
		}
		String oids = "";
		OrderMsgExample orderMsgE = new OrderMsgExample();
		OrderMsgExample.Criteria orderMsgC = orderMsgE.createCriteria();
		orderMsgC.andUidEqualTo(login.getId());
		orderMsgC.andOrderStatusEqualTo(1);
		List<OrderMsg> orderMsgList = orderMsgMapper.selectByExample(orderMsgE);
		List<Map<String,Object>> orderMsgList2 = new ArrayList<Map<String,Object>>();
		Double totalAmount=0.0;//总金额计算
		for(OrderMsg orderMsg:orderMsgList){
			oids+=orderMsg.getId()+",";
			totalAmount+=orderMsg.getPayAmount();
		}
		modelMap.addAttribute("totalAmount", df.format(totalAmount));
		modelMap.addAttribute("oids", oids);
		return "index/order_msg_go_pay";
	}
	//提交订单，改变订单状态为已付款
	@RequestMapping(value = "submitOrderMsg")
	@ResponseBody
	public Object submitOrderMsg(ModelMap modelMap,String oids, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		List<Integer> oids1 = new ArrayList<Integer>();
		if(oids!=null&&oids.trim().equals("")==false){
			String [] split = oids.split(",");
			for(String str:split){
				if(str.trim().equals("")==false){
					oids1.add(Integer.parseInt(str.trim()));
				}
			}
		}
		if (oids1.size()==0) {
			rs.put("code", 0);
			rs.put("msg","无待支付订单");
			return rs;
		}
		OrderMsgExample orderMsgE = new OrderMsgExample();
		OrderMsgExample.Criteria orderMsgC =orderMsgE.createCriteria();
		orderMsgC.andIdIn(oids1);
		List<OrderMsg> orderMsgList = orderMsgMapper.selectByExample(orderMsgE);
		for(OrderMsg orderMsg:orderMsgList){
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(orderMsg.getPid());
			if(proMsg==null){
				rs.put("code",0);
				rs.put("msg","该商品已不存在");
				return rs;
			}
			Integer proStockNum =0;
			for(OrderMsg orderMsg1:orderMsgList){
				if(orderMsg1.getPid().equals(proMsg.getId())){
					proStockNum+=orderMsg1.getOrderNum();
				}
			}
			if(proMsg.getProStockNum()==null||proMsg.getProStockNum().compareTo(proStockNum)<0){
				rs.put("code",0);
				rs.put("msg","商品库存数量不足");
				return rs;
			}
		}
		for(OrderMsg orderMsg:orderMsgList){
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(orderMsg.getPid());
			proMsg.setProStockNum(proMsg.getProStockNum()-orderMsg.getOrderNum());
			proMsgMapper.updateByPrimaryKeySelective(proMsg);
			proMsg.setSaleNum(proMsg.getSaleNum()+orderMsg.getOrderNum());
			proMsgMapper.updateByPrimaryKeySelective(proMsg);
			orderMsg.setOrderStatus(2);
			orderMsgMapper.updateByPrimaryKeySelective(orderMsg);
		}
		rs.put("code", 1);
		rs.put("msg","支付成功");
		return rs;
	}
	//支付成功页面
	@RequestMapping(value = "paySuccess")
	public Object paySuccess(ModelMap modelMap, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("login", login);
		return "index/pay_success";
	}
	//删除某个订单接口
	@RequestMapping(value = "delOrderMsg")
	@ResponseBody
	public Object delOrder(ModelMap modelMap, HttpServletRequest request, Integer id) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		if(login==null||login.getLoginType()!=2){
			rs.put("code", 0);
			rs.put("msg","尚未登录");
			return rs;
		}
		orderMsgMapper.deleteByPrimaryKey(id);
		rs.put("code", 1);
		rs.put("msg","删除成功");
		return rs;
	}
}
