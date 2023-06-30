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
public class CartServiceImpl implements CartService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	@Autowired
	CartMapper cartMapper;
	/**
	*根据参数查询购物车列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Cart queryModel,Integer pageSize,LoginModel login) {
		CartExample se = new CartExample();
		CartExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		int count = (int)cartMapper.countByExample(se);
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
	*根据参数查询购物车列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Cart queryModel,Integer page,Integer pageSize,LoginModel login) {
		CartExample se = new CartExample();
		CartExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Cart> list = cartMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Cart model:list){
			list2.add(getCartModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装购物车为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getCartModel(Cart model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cart",model);
		if(model.getPid()!=null){
			ProMsg proMsg = proMsgMapper.selectByPrimaryKey(model.getPid());//商品ID为外接字段，需要关联商品来解释该字段
			if(proMsg!=null){
				map.put("pidStr",proMsg.getProTitle());
			}
		}
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//会员ID为外接字段，需要关联会员来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		return map;
	}
}
