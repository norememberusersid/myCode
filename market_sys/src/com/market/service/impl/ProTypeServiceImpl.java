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
public class ProTypeServiceImpl implements ProTypeService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	ProTypeMapper proTypeMapper;
	/**
	新增
	*/
	@Override
	public String add(ProType model,LoginModel login){
		if(model.getTypeName()==null||model.getTypeName().equals("")){
			return "类型名为必填属性";
		}
		proTypeMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(ProType model,LoginModel login){
		ProType preModel = proTypeMapper.selectByPrimaryKey(model.getId());
		if(model.getTypeName()==null||model.getTypeName().equals("")){
			return "类型名为必填属性";
		}
		preModel.setTypeName(model.getTypeName());
		proTypeMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询商品类型列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(ProType queryModel,Integer pageSize,LoginModel login) {
		ProTypeExample se = new ProTypeExample();
		ProTypeExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getTypeName()!=null&&queryModel.getTypeName().equals("")==false){
			sc.andTypeNameLike("%"+queryModel.getTypeName()+"%");//模糊查询
		}
		int count = (int)proTypeMapper.countByExample(se);
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
	*根据参数查询商品类型列表数据
	*/
	@Override
	public Map<String,Object> getDataList(ProType queryModel,Integer page,Integer pageSize,LoginModel login) {
		ProTypeExample se = new ProTypeExample();
		ProTypeExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getTypeName()!=null&&queryModel.getTypeName().equals("")==false){
			sc.andTypeNameLike("%"+queryModel.getTypeName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<ProType> list = proTypeMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(ProType model:list){
			list2.add(getProTypeModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装商品类型为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getProTypeModel(ProType model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("proType",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		proTypeMapper.deleteByPrimaryKey(id);
	}
}
