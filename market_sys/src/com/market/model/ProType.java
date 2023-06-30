package com.market.model;
public class ProType {
	private Integer id;//ID
	private String typeName;//类型名
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setTypeName(String typeName){
		this.typeName = typeName == null ? null : typeName.trim();
	}
}
