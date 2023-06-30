package com.market.service;
import java.util.Map;
import com.market.controller.LoginModel;
import com.market.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ProTypeService{
	/**
	分页查询商品类型数据总数
	*/
	public Map<String,Integer> getDataListCount(ProType queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询商品类型数据列表
	*/
	public Map<String,Object> getDataList(ProType queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装商品类型为前台展示的数据形式
	*/
	public Map<String,Object> getProTypeModel(ProType model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(ProType model,LoginModel login);
	/**
	修改
	*/
	public String update(ProType model,LoginModel login);
}
