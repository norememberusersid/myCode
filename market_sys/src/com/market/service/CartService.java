package com.market.service;
import java.util.Map;
import com.market.controller.LoginModel;
import com.market.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface CartService{
	/**
	分页查询购物车数据总数
	*/
	public Map<String,Integer> getDataListCount(Cart queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询购物车数据列表
	*/
	public Map<String,Object> getDataList(Cart queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装购物车为前台展示的数据形式
	*/
	public Map<String,Object> getCartModel(Cart model,LoginModel login);
}
