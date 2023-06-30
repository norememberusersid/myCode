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
@RequestMapping("/admin/pro_msg")
public class AProMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	ProMsgService proMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	ProTypeMapper proTypeMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		ProTypeExample proTypeE = new ProTypeExample();
		List<ProType> proTypeList=proTypeMapper.selectByExample(proTypeE);
		List<Map<String,Object>>  proTypeList2 = new ArrayList<Map<String,Object>>();
		for(ProType m:proTypeList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getTypeName());
			proTypeList2.add(map);
		}
		modelMap.addAttribute("proTypeList",proTypeList2);
		modelMap.addAttribute("isUpList",DataListUtils.getIsUpList());//返回is_up列表
	}
	/**
	* 根据查询条件分页查询商品数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(ProMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return proMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回商品列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/pro_msg/list";
	}
	/**
	* 根据查询条件分页查询商品数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(ProMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return proMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,ProMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "admin/pro_msg/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(ProMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = proMsgService.add(model,login);//执行添加操作
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
	public String update(ModelMap modelMap,ProMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		ProMsg data = proMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/pro_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(ProMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = proMsgService.update(model,login);//执行修改操作
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
	删除商品接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		proMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
