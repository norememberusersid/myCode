package com.market.controller.admin;
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
@RequestMapping("/admin/user_msg")
public class AUserMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	UserMsgService userMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("sexList",DataListUtils.getSexList());//返回sex列表
	}
	/**
	* 根据查询条件分页查询会员数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(UserMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return userMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回会员列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/user_msg/list";
	}
	/**
	* 根据查询条件分页查询会员数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(UserMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return userMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "admin/user_msg/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update")
	public String update(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		UserMsg data = userMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/user_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除会员接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		userMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
