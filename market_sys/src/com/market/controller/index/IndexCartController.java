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
@RequestMapping("index/cart")
public class IndexCartController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	CartMapper cartMapper;
	@Autowired
	OrderMsgMapper orderMsgMapper;
	@Autowired
	IndexProDetailController indexProDetailController;
	//进入购物车页面
	@RequestMapping(value = "")
	public String index(ModelMap modelMap, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("login", login);
		if(login==null||login.getLoginType()!=2){
			modelMap.addAttribute("msg","尚未登录");
			return "index/error";
		}
		//查询该会员的购物车
		CartExample cartE = new CartExample();
		CartExample.Criteria cartC = cartE.createCriteria();
		cartC.andUidEqualTo(login.getId());//cart.uid=当前登录id
		List<Cart> cartList = cartMapper.selectByExample(cartE);
		List<Map<String,Object>> cartList2  = new ArrayList<Map<String,Object>>();
		for(Cart cart:cartList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",cart.getId());
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(cart.getPid());//查询商品
			if(proMsg==null){
				continue;
			}
			map.put("cartProTitle",proMsg.getProTitle());
			map.put("cartProImg",proMsg.getProImg());
			map.put("proMsgId",proMsg.getId());
			map.put("cartProPrice",proMsg.getProPrice());
			map.put("totalAmount", df.format(proMsg.getProPrice()*cart.getNum()));//单个商品总额
			map.put("id",cart.getId());
			map.put("pid",cart.getPid());
			map.put("num",cart.getNum());
			map.put("uid",cart.getUid());
			map.put("createTime",cart.getCreateTime());
			cartList2.add(map);
		}
		modelMap.addAttribute("cartList",cartList2);
		return "index/cart";
	}
	//加入购物车接口
	@RequestMapping("addToCart")
	@ResponseBody
	public Object addToCart(HttpServletRequest request,Cart cart){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		cart.setUid(login.getId());
		//查询原先已加过该商品进购物车
		CartExample cartE = new CartExample();
		CartExample.Criteria cartC = cartE.createCriteria();
		cartC.andPidEqualTo(cart.getPid());
		cartC.andUidEqualTo(login.getId());
		List<Cart> cartList = cartMapper.selectByExample(cartE);
		if(cartList.size()>0){//原先加过购物车，则更新数量加1
			Cart cart2 =cartList.get(0);
			cart2.setNum(cart2.getNum()+1);
			cartMapper.updateByPrimaryKey(cart2);
		}else{//原先没加过，则新建购物车并插入数据库
			cart.setUid(login.getId());//登录id
			cart.setCreateTime(sdf1.format(new Date()));//当前时间格式
			cartMapper.insertSelective(cart);
		}
		rs.put("code",1);
		rs.put("msg","提交购物车成功");
		return rs;
	}
	@RequestMapping(value = "batchRemoveCart")
	@ResponseBody
	public Object batchRemoveCart(ModelMap modelMap, String ids,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		if (login == null||login.getLoginType()!=2) {
			rs.put("code", 0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if ((ids == null) || ids.equals("")) {
			rs.put("msg", "请选择要删除的购物车选项");
			rs.put("code", 0);
			return rs;
		}
		List<Integer> ids2 = new ArrayList<Integer>();
		String[] idplit = ids.split(",");
		for (String s : idplit) {
			if (s.trim().equals("") == false) {
				ids2.add(Integer.parseInt(s));
			}
		}
		CartExample cartE = new CartExample();
		CartExample.Criteria cartC = cartE.createCriteria();
		cartC.andIdIn(ids2);
		cartMapper.deleteByExample(cartE);
		rs.put("code", 1);
		rs.put("msg","删除成功");
		return rs;
	}
	//更新购物车数量
	@RequestMapping(value = "updateCartNum")
	@ResponseBody
	public Object updateCartNum(ModelMap modelMap, Integer id, Integer type, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		if (login == null||login.getLoginType()!=2) {
			rs.put("code", 0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if ((id == null) || (type == null)) {
			rs.put("code", 0);
			rs.put("msg","参数错误");
			return rs;
		}
		Cart cart = cartMapper.selectByPrimaryKey(id);
		if (type == 2) {
			if (cart.getNum() == 1) {
				cartMapper.deleteByPrimaryKey(cart.getId()); //将该条购物车数据删掉
			} else {
				cart.setNum(cart.getNum() - 1);
				cartMapper.updateByPrimaryKeySelective(cart);
			}
		} else {
			cart.setNum(cart.getNum() + 1);
			cartMapper.updateByPrimaryKeySelective(cart);
		}
		rs.put("code", 1);
		return rs;
	}
	//删除购物车
	@RequestMapping(value = "removeCart")
	@ResponseBody
	public Object removeCart(ModelMap modelMap, Integer id, HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		if (login == null||login.getLoginType()!=2) {
			rs.put("code", 0);
			rs.put("msg","尚未登录");
			return rs;
		}
		cartMapper.deleteByPrimaryKey(id);
		rs.put("code", 1);
		rs.put("msg","删除成功");
		return rs;
	}
	//提交购物车到订单
	@RequestMapping("submitCart")
	@ResponseBody
	public Object submitCart(HttpServletRequest request,String ids){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		if (login == null||login.getLoginType()!=2) {
			rs.put("code", 0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if ((ids == null) || ids.equals("")) {
			rs.put("msg", "请选择要提交的购物车");
			rs.put("code", 0);
			return rs;
		}
		List<Integer> ids2 = new ArrayList<Integer>();
		String[] idplit = ids.split(",");
		for (String s : idplit) {
			if (s.trim().equals("") == false) {
				ids2.add(Integer.parseInt(s));
			}
		}
		//查询购物车列表
		CartExample cartE = new CartExample();
		CartExample.Criteria cartC = cartE.createCriteria();
		cartC.andIdIn(ids2);
		List<Cart> cartList = cartMapper.selectByExample(cartE);
		List<OrderMsg> orderMsgList = new ArrayList<OrderMsg>();
		for(Cart cart:cartList){
			OrderMsg orderMsg = new OrderMsg();
			orderMsg.setUid(login.getId());
			orderMsg.setPid(cart.getPid());
			orderMsg.setOrderNum(cart.getNum());
			orderMsgList.add(orderMsg);
		}
		for(OrderMsg orderMsg:orderMsgList){
			Map<String,Object> check1 = indexProDetailController.checkOrderMsg(request,orderMsg);
			if(check1.get("code").toString().equals("0")){
				return check1;
			}
		}
		for(OrderMsg orderMsg:orderMsgList){
			//调用indexProDetailController中提交订单方法，提交购物车
			indexProDetailController.addOrderMsg(request,orderMsg);
		}
		cartMapper.deleteByExample(cartE);//删除该会员的所有的购物车
		rs.put("msg", "提交成功");
		rs.put("code", 1);
		return rs;
	}
}
