package com.market.controller.user;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.market.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.market.controller.LoginModel;
import com.market.util.CommonVal;
import  com.market.model.*;
import com.market.dao.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
@Controller
@RequestMapping("/user/index")
public class UIndexController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	会员角色进入管理首页接口
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		UserMsg user = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("roleName", "会员");
		modelMap.addAttribute("login", login);
		return "user/index";
	}
}
