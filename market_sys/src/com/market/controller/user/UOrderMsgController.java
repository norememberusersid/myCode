package com.market.controller.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.impl.*;
import com.market.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.market.controller.LoginModel;
import com.market.service.*;
@Controller
@RequestMapping("/user/order_msg")
public class UOrderMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	OrderMsgService orderMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	OrderMsgMapper orderMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("orderStatusList",DataListUtils.getOrderStatusList());//返回order_status列表
	}
	/**
	* 根据查询条件分页查询订单数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(OrderMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return orderMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回订单列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "user/order_msg/list";
	}
	/**
	* 根据查询条件分页查询订单数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(OrderMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return orderMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	@RequestMapping(value = "qrsh")
	@ResponseBody
	public Object qrsh(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		OrderMsg model = orderMsgMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该订单已不存在");
			return rs;
		}
		model.setOrderStatus(4);
		orderMsgMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","确认收货成功");
		return rs;
	}
}
