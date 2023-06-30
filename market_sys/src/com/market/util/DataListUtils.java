package com.market.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
*
数据列表解释器，键值对列举说明工具，例如性别字段：1表示男，2表示女
*
*/
public class DataListUtils {
	public static void main(String[] args) {
	}
	/**
	**获取登录角色列表
	*/
	public static List<Map<String,Object>> getLoginTypeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","admin"));
		list.add(getMap("2","user"));
		return list;
	}
	/**
	**获取sex数据列表
	*/
	public static List<Map<String,Object>> getSexList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","男"));
		list.add(getMap("2","女"));
		return list;
	}
	public static String getSexNameById(String id){//根据sex的key值获取名称
		List<Map<String,Object>> list = getSexList();
		return getNameById(id,list);
	}
	/**
	**获取is_up数据列表
	*/
	public static List<Map<String,Object>> getIsUpList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","上架"));
		list.add(getMap("2","下架"));
		return list;
	}
	public static String getIsUpNameById(String id){//根据is_up的key值获取名称
		List<Map<String,Object>> list = getIsUpList();
		return getNameById(id,list);
	}
	/**
	**获取order_status数据列表
	*/
	public static List<Map<String,Object>> getOrderStatusList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","待付款"));
		list.add(getMap("2","已付款"));
		list.add(getMap("3","已发货"));
		list.add(getMap("4","已确认收货"));
		return list;
	}
	public static String getOrderStatusNameById(String id){//根据order_status的key值获取名称
		List<Map<String,Object>> list = getOrderStatusList();
		return getNameById(id,list);
	}
	public static String getNameById(String id,List<Map<String,Object>> list){
		if(id==null){
			return null;
		}
		if(id.endsWith(",")){
			id = id.substring(0,id.length()-1);
		}
		String[] idsplit = id.split(",");
		String rs = "";
		for(String tmp:idsplit){
			for(Map<String,Object> map:list){
				if(map.get("id").toString().equals(tmp)){
					rs+=map.get("name").toString()+",";
				}
			}
		}
		if(rs.endsWith(",")){
			rs = rs.substring(0,rs.length()-1);
		}
		return rs;
	}
	private static Map<String,Object> getMap(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
}
