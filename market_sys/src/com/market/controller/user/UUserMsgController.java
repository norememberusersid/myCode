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
@RequestMapping("/user/user_msg")
public class UUserMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	UserMsgService userMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("sexList",DataListUtils.getSexList());//返回sex列表
	}
	/**
	进入会员详情页
	*/
	@RequestMapping("detail")
	public Object detail(ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		UserMsg model = new UserMsg();
		model.setId(login.getId());
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("detail",userMsgService.getUserMsgModel(preModel,login));
		return "user/personal";
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update1")
	public String update1(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		UserMsg data = userMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "user/user_msg/update1_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update1_submit")
	@ResponseBody
	public Object update1_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.update1(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
}
