package com.market.controller.index;
import com.market.controller.*;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.*;
import com.market.util.*;
import com.market.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("index/pro_search")
public class IndexProSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	ProTypeMapper proTypeMapper;
	@Autowired
	ProMsgMapper proMsgMapper;
	//商品搜索页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap, HttpServletRequest request) {
		ProTypeExample proTypeE = new ProTypeExample();
		modelMap.addAttribute("tableProTypeList",proTypeMapper.selectByExample(proTypeE));
		return "index/pro_search";
	}
	//获取商品列表数据
	@RequestMapping("queryProMsgList")
	@ResponseBody
	public Object queryProMsgList(HttpServletRequest request,Integer page,String proTitle,Integer pid){
		ProMsgExample qe = new ProMsgExample();
		ProMsgExample.Criteria qc = qe.createCriteria();
		qc.andIsUpEqualTo(1);//是否上架等于上架
		if(proTitle!=null&&proTitle.trim().equals("")==false){
			qc.andProTitleLike("%"+proTitle+"%");
		}
		if(pid!=null){
			qc.andPidEqualTo(pid);
		}
		qe.setOrderByClause("sale_num desc");
		int pageSize=8;
		int count = (int) proMsgMapper.countByExample(qe);
		int totalPage = 0;
		if (page != null) {
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			qe.setPageRows(pageSize);//每页数量
			qe.setStartRow((page - 1) * pageSize);//第几页
		}
		List<ProMsg> ql=proMsgMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(ProMsg tmp:ql){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释商品类型
			ProType pidT = proTypeMapper.selectByPrimaryKey(tmp.getPid());
			if(pidT==null){
				pidT = new ProType();
			}
			amap.put("pid",pidT.getTypeName());
			amap.put("model",tmp);
			qlList.add(amap);
		}
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("count",count);
		rs.put("totalPage",totalPage);
		rs.put("list",qlList);
		rs.put("pageSize",pageSize);
		return rs;
	}
}
