package com.market.model;
public class Cart {
	private Integer id;//ID
	private Integer pid;//商品ID
	private Integer num;//数量
	private Integer uid;//会员ID
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getPid(){
		return pid;
	}
	public void setPid(Integer pid){
		this.pid = pid;
	}
	public Integer getNum(){
		return num;
	}
	public void setNum(Integer num){
		this.num = num;
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
