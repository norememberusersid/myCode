package com.market.service;
import java.util.Map;
import com.market.controller.LoginModel;
import com.market.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface OrderMsgService{
	/**
	分页查询订单数据总数
	*/
	public Map<String,Integer> getDataListCount(OrderMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询订单数据列表
	*/
	public Map<String,Object> getDataList(OrderMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装订单为前台展示的数据形式
	*/
	public Map<String,Object> getOrderMsgModel(OrderMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
