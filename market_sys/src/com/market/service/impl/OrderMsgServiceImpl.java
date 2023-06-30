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
public class OrderMsgServiceImpl implements OrderMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	OrderMsgMapper orderMsgMapper;
	/**
	*根据参数查询订单列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(OrderMsg queryModel,Integer pageSize,LoginModel login) {
		OrderMsgExample se = new OrderMsgExample();
		OrderMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getOrderNo()!=null&&queryModel.getOrderNo().equals("")==false){
			sc.andOrderNoLike("%"+queryModel.getOrderNo()+"%");//模糊查询
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询订单状态等于指定值
		}
		int count = (int)orderMsgMapper.countByExample(se);
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
	*根据参数查询订单列表数据
	*/
	@Override
	public Map<String,Object> getDataList(OrderMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		OrderMsgExample se = new OrderMsgExample();
		OrderMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getOrderNo()!=null&&queryModel.getOrderNo().equals("")==false){
			sc.andOrderNoLike("%"+queryModel.getOrderNo()+"%");//模糊查询
		}
		if(queryModel.getOrderStatus()!=null){
			sc.andOrderStatusEqualTo(queryModel.getOrderStatus());//查询订单状态等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<OrderMsg> list = orderMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(OrderMsg model:list){
			list2.add(getOrderMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装订单为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getOrderMsgModel(OrderMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderMsg",model);
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//会员ID为外接字段，需要关联会员来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		if(model.getPid()!=null){
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(model.getPid());//商品ID为外接字段，需要关联商品来解释该字段
			if(proMsg!=null){
				map.put("pidStr",proMsg.getProTitle());
			}
		}
		map.put("orderStatusStr",DataListUtils.getOrderStatusNameById(model.getOrderStatus()+""));//解释订单状态字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		orderMsgMapper.deleteByPrimaryKey(id);
	}
}
