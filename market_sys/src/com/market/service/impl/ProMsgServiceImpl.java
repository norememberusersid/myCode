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
public class ProMsgServiceImpl implements ProMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	ProTypeMapper proTypeMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(ProMsg model,LoginModel login){
		if(model.getProTitle()==null||model.getProTitle().equals("")){
			return "商品标题为必填属性";
		}
		if(model.getProImg()==null||model.getProImg().equals("")){
			return "商品大图为必填属性";
		}
		if(model.getProImg()!=null){
			String [] fileSplit = model.getProImg().split(";");
			if(fileSplit.length>1){
				return "商品大图的图片数量不能大于1";
			}
		}
		if(model.getPid()==null){
			return "商品类型为必填属性";
		}
		if(model.getProPrice()==null){
			return "价格为必填属性";
		}
		if(model.getProStockNum()==null){
			return "库存数量为必填属性";
		}
		if(model.getProIntro()==null||model.getProIntro().equals("")){
			return "商品简介为必填属性";
		}
		if(model.getProDetail()==null||model.getProDetail().equals("")){
			return "商品详情图为必填属性";
		}
		if(model.getProDetail()!=null){
			String [] fileSplit = model.getProDetail().split(";");
			if(fileSplit.length>5){
				return "商品详情图的图片数量不能大于5";
			}
		}
		if(model.getIsUp()==null){
			return "是否上架为必填属性";
		}
		model.setSaleNum(0);//默认0
		proMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(ProMsg model,LoginModel login){
		ProMsg preModel = proMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getProTitle()==null||model.getProTitle().equals("")){
			return "商品标题为必填属性";
		}
		if(model.getProImg()==null||model.getProImg().equals("")){
			return "商品大图为必填属性";
		}
		if(model.getProImg()!=null){
			String [] fileSplit = model.getProImg().split(";");
			if(fileSplit.length>1){
				return "商品大图的图片数量不能大于1";
			}
		}
		if(model.getPid()==null){
			return "商品类型为必填属性";
		}
		if(model.getProPrice()==null){
			return "价格为必填属性";
		}
		if(model.getProStockNum()==null){
			return "库存数量为必填属性";
		}
		if(model.getProIntro()==null||model.getProIntro().equals("")){
			return "商品简介为必填属性";
		}
		if(model.getProDetail()==null||model.getProDetail().equals("")){
			return "商品详情图为必填属性";
		}
		if(model.getProDetail()!=null){
			String [] fileSplit = model.getProDetail().split(";");
			if(fileSplit.length>5){
				return "商品详情图的图片数量不能大于5";
			}
		}
		if(model.getIsUp()==null){
			return "是否上架为必填属性";
		}
		preModel.setProTitle(model.getProTitle());
		preModel.setProImg(model.getProImg());
		preModel.setPid(model.getPid());
		preModel.setProPrice(model.getProPrice());
		preModel.setProStockNum(model.getProStockNum());
		preModel.setProIntro(model.getProIntro());
		preModel.setProDetail(model.getProDetail());
		preModel.setIsUp(model.getIsUp());
		proMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询商品列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(ProMsg queryModel,Integer pageSize,LoginModel login) {
		ProMsgExample se = new ProMsgExample();
		ProMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getProTitle()!=null&&queryModel.getProTitle().equals("")==false){
			sc.andProTitleLike("%"+queryModel.getProTitle()+"%");//模糊查询
		}
		if(queryModel.getIsUp()!=null){
			sc.andIsUpEqualTo(queryModel.getIsUp());//查询是否上架等于指定值
		}
		int count = (int)proMsgMapper.countByExample(se);
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
	*根据参数查询商品列表数据
	*/
	@Override
	public Map<String,Object> getDataList(ProMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		ProMsgExample se = new ProMsgExample();
		ProMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getProTitle()!=null&&queryModel.getProTitle().equals("")==false){
			sc.andProTitleLike("%"+queryModel.getProTitle()+"%");//模糊查询
		}
		if(queryModel.getIsUp()!=null){
			sc.andIsUpEqualTo(queryModel.getIsUp());//查询是否上架等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<ProMsg> list = proMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(ProMsg model:list){
			list2.add(getProMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装商品为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getProMsgModel(ProMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("proMsg",model);
		if(model.getPid()!=null){
			ProType proType = proTypeMapper.selectByPrimaryKey(model.getPid());//商品类型为外接字段，需要关联商品类型来解释该字段
			if(proType!=null){
				map.put("pidStr",proType.getTypeName());
			}
		}
		List<String> proDetailList = new ArrayList<String>();
		if(model.getProDetail()!=null){
			String [] proDetailSplit = model.getProDetail().split(";");
			for(String tmpstr:proDetailSplit ){
				if(tmpstr.equals("")==false){
					proDetailList.add(tmpstr);
				}
			}
		}
		map.put("proDetailList",proDetailList);
		map.put("isUpStr",DataListUtils.getIsUpNameById(model.getIsUp()+""));//解释是否上架字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		proMsgMapper.deleteByPrimaryKey(id);
	}
}
