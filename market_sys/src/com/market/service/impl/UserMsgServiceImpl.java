package com.market.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.market.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.market.service.*;
import com.market.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class UserMsgServiceImpl implements UserMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(UserMsg model,LoginModel login){
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getBirthday()==null||model.getBirthday().equals("")){
			return "生日为必填属性";
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "地址为必填属性";
		}
		model.setUserScore(0);//默认0
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		String today = sdf2.format(new Date());
		userMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(UserMsg model,LoginModel login){
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getBirthday()==null||model.getBirthday().equals("")){
			return "生日为必填属性";
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "地址为必填属性";
		}
		preModel.setLoginName(model.getLoginName());
		preModel.setPassword(model.getPassword());
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setBirthday(model.getBirthday());
		preModel.setSex(model.getSex());
		preModel.setAddress(model.getAddress());
		String today = sdf2.format(new Date());
		userMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(UserMsg model,LoginModel login){
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getBirthday()==null||model.getBirthday().equals("")){
			return "生日为必填属性";
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "地址为必填属性";
		}
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setBirthday(model.getBirthday());
		preModel.setSex(model.getSex());
		preModel.setAddress(model.getAddress());
		String today = sdf2.format(new Date());
		userMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询会员列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(UserMsg queryModel,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)userMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询会员列表数据
	*/
	@Override
	public Map<String,Object> getDataList(UserMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<UserMsg> list = userMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(UserMsg model:list){
			list2.add(getUserMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装会员为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getUserMsgModel(UserMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userMsg",model);
		map.put("sexStr",DataListUtils.getSexNameById(model.getSex()+""));//解释性别字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		userMsgMapper.deleteByPrimaryKey(id);
	}
}
