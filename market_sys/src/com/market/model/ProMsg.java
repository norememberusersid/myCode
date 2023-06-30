package com.market.model;
public class ProMsg {
	private Integer id;//ID
	private String proTitle;//商品标题
	private String proImg;//商品大图
	private Integer pid;//商品类型
	private Double proPrice;//价格
	private Integer proStockNum;//库存数量
	private String proIntro;//商品简介
	private String proDetail;//商品详情图
	private Integer saleNum;//销量
	private Integer isUp;//是否上架
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getProTitle(){
		return proTitle;
	}
	public void setProTitle(String proTitle){
		this.proTitle = proTitle == null ? null : proTitle.trim();
	}
	public String getProImg(){
		return proImg;
	}
	public void setProImg(String proImg){
		this.proImg = proImg == null ? null : proImg.trim();
	}
	public Integer getPid(){
		return pid;
	}
	public void setPid(Integer pid){
		this.pid = pid;
	}
	public Double getProPrice(){
		return proPrice;
	}
	public void setProPrice(Double proPrice){
		this.proPrice = proPrice;
	}
	public Integer getProStockNum(){
		return proStockNum;
	}
	public void setProStockNum(Integer proStockNum){
		this.proStockNum = proStockNum;
	}
	public String getProIntro(){
		return proIntro;
	}
	public void setProIntro(String proIntro){
		this.proIntro = proIntro == null ? null : proIntro.trim();
	}
	public String getProDetail(){
		return proDetail;
	}
	public void setProDetail(String proDetail){
		this.proDetail = proDetail == null ? null : proDetail.trim();
	}
	public Integer getSaleNum(){
		return saleNum;
	}
	public void setSaleNum(Integer saleNum){
		this.saleNum = saleNum;
	}
	public Integer getIsUp(){
		return isUp;
	}
	public void setIsUp(Integer isUp){
		this.isUp = isUp;
	}
}
