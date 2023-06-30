package com.market.model;
public class OrderMsg {
	private Integer id;//ID
	private String orderNo;//订单编号
	private Integer uid;//会员ID
	private String urealName;//会员姓名
	private String ucelPhone;//联系电话
	private String uaddress;//会员地址
	private Integer pid;//商品ID
	private Double pproPrice;//商品价格
	private Integer orderNum;//数量
	private String totalAmount;//应付金额
	private Integer orderStatus;//订单状态
	private String createTime;//创建时间
	private Double payAmount;//实付金额
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public String getUrealName(){
		return urealName;
	}
	public void setUrealName(String urealName){
		this.urealName = urealName == null ? null : urealName.trim();
	}
	public String getUcelPhone(){
		return ucelPhone;
	}
	public void setUcelPhone(String ucelPhone){
		this.ucelPhone = ucelPhone == null ? null : ucelPhone.trim();
	}
	public String getUaddress(){
		return uaddress;
	}
	public void setUaddress(String uaddress){
		this.uaddress = uaddress == null ? null : uaddress.trim();
	}
	public Integer getPid(){
		return pid;
	}
	public void setPid(Integer pid){
		this.pid = pid;
	}
	public Double getPproPrice(){
		return pproPrice;
	}
	public void setPproPrice(Double pproPrice){
		this.pproPrice = pproPrice;
	}
	public Integer getOrderNum(){
		return orderNum;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum = orderNum;
	}
	public String getTotalAmount(){
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount){
		this.totalAmount = totalAmount == null ? null : totalAmount.trim();
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Double getPayAmount(){
		return payAmount;
	}
	public void setPayAmount(Double payAmount){
		this.payAmount = payAmount;
	}
}
