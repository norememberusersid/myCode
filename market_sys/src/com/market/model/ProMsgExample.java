package com.market.model;
import java.util.ArrayList;
import java.util.List;
public class ProMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public ProMsgExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andProTitleIsNull() {
			addCriterion("pro_title is null");
			return (Criteria) this;
		}
		public Criteria andProTitleIsNotNull(){
			addCriterion("pro_title is not null");
			return (Criteria) this;
		}
		public Criteria andProTitleEqualTo(String value) {
			addCriterion("pro_title =", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleNotEqualTo(String value) {
			addCriterion("pro_title <>", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleGreaterThan(String value) {
			addCriterion("pro_title >", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleGreaterThanOrEqualTo(String value) {
			addCriterion("pro_title >=", value, "ProTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleLessThan(String value) {
			addCriterion("pro_title <", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleLessThanOrEqualTo(String value) {
			addCriterion("pro_title <=", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleIn(List<String> values) {
			addCriterion("pro_title in", values, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleNotIn(List<String> values) {
			addCriterion("pro_title not in", values, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleBetween(String value1, String value2) {
			addCriterion("pro_title between", value1, value2, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleNotBetween(String value1, String value2) {
			addCriterion("pro_title not between", value1, value2, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleLike(String value) {
			addCriterion("pro_title like", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProTitleNotLike(String value) {
			addCriterion("pro_title not like", value, "proTitle");
			return (Criteria) this;
		}
		public Criteria andProImgIsNull() {
			addCriterion("pro_img is null");
			return (Criteria) this;
		}
		public Criteria andProImgIsNotNull(){
			addCriterion("pro_img is not null");
			return (Criteria) this;
		}
		public Criteria andProImgEqualTo(String value) {
			addCriterion("pro_img =", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgNotEqualTo(String value) {
			addCriterion("pro_img <>", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgGreaterThan(String value) {
			addCriterion("pro_img >", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgGreaterThanOrEqualTo(String value) {
			addCriterion("pro_img >=", value, "ProImg");
			return (Criteria) this;
		}
		public Criteria andProImgLessThan(String value) {
			addCriterion("pro_img <", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgLessThanOrEqualTo(String value) {
			addCriterion("pro_img <=", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgIn(List<String> values) {
			addCriterion("pro_img in", values, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgNotIn(List<String> values) {
			addCriterion("pro_img not in", values, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgBetween(String value1, String value2) {
			addCriterion("pro_img between", value1, value2, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgNotBetween(String value1, String value2) {
			addCriterion("pro_img not between", value1, value2, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgLike(String value) {
			addCriterion("pro_img like", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andProImgNotLike(String value) {
			addCriterion("pro_img not like", value, "proImg");
			return (Criteria) this;
		}
		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return (Criteria) this;
		}
		public Criteria andPidIsNotNull(){
			addCriterion("pid is not null");
			return (Criteria) this;
		}
		public Criteria andPidEqualTo(Integer value) {
			addCriterion("pid =", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidNotEqualTo(Integer value) {
			addCriterion("pid <>", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidGreaterThan(Integer value) {
			addCriterion("pid >", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("pid >=", value, "Pid");
			return (Criteria) this;
		}
		public Criteria andPidLessThan(Integer value) {
			addCriterion("pid <", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidLessThanOrEqualTo(Integer value) {
			addCriterion("pid <=", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidIn(List<Integer> values) {
			addCriterion("pid in", values, "pid");
			return (Criteria) this;
		}
		public Criteria andPidNotIn(List<Integer> values) {
			addCriterion("pid not in", values, "pid");
			return (Criteria) this;
		}
		public Criteria andPidBetween(Integer value1, Integer value2) {
			addCriterion("pid between", value1, value2, "pid");
			return (Criteria) this;
		}
		public Criteria andPidNotBetween(Integer value1, Integer value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return (Criteria) this;
		}
		public Criteria andPidLike(Integer value) {
			addCriterion("pid like", value, "pid");
			return (Criteria) this;
		}
		public Criteria andPidNotLike(Integer value) {
			addCriterion("pid not like", value, "pid");
			return (Criteria) this;
		}
		public Criteria andProPriceIsNull() {
			addCriterion("pro_price is null");
			return (Criteria) this;
		}
		public Criteria andProPriceIsNotNull(){
			addCriterion("pro_price is not null");
			return (Criteria) this;
		}
		public Criteria andProPriceEqualTo(Double value) {
			addCriterion("pro_price =", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceNotEqualTo(Double value) {
			addCriterion("pro_price <>", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceGreaterThan(Double value) {
			addCriterion("pro_price >", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceGreaterThanOrEqualTo(Double value) {
			addCriterion("pro_price >=", value, "ProPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceLessThan(Double value) {
			addCriterion("pro_price <", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceLessThanOrEqualTo(Double value) {
			addCriterion("pro_price <=", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceIn(List<Double> values) {
			addCriterion("pro_price in", values, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceNotIn(List<Double> values) {
			addCriterion("pro_price not in", values, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceBetween(Double value1, Double value2) {
			addCriterion("pro_price between", value1, value2, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceNotBetween(Double value1, Double value2) {
			addCriterion("pro_price not between", value1, value2, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceLike(Double value) {
			addCriterion("pro_price like", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProPriceNotLike(Double value) {
			addCriterion("pro_price not like", value, "proPrice");
			return (Criteria) this;
		}
		public Criteria andProStockNumIsNull() {
			addCriterion("pro_stock_num is null");
			return (Criteria) this;
		}
		public Criteria andProStockNumIsNotNull(){
			addCriterion("pro_stock_num is not null");
			return (Criteria) this;
		}
		public Criteria andProStockNumEqualTo(Integer value) {
			addCriterion("pro_stock_num =", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumNotEqualTo(Integer value) {
			addCriterion("pro_stock_num <>", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumGreaterThan(Integer value) {
			addCriterion("pro_stock_num >", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("pro_stock_num >=", value, "ProStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumLessThan(Integer value) {
			addCriterion("pro_stock_num <", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumLessThanOrEqualTo(Integer value) {
			addCriterion("pro_stock_num <=", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumIn(List<Integer> values) {
			addCriterion("pro_stock_num in", values, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumNotIn(List<Integer> values) {
			addCriterion("pro_stock_num not in", values, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumBetween(Integer value1, Integer value2) {
			addCriterion("pro_stock_num between", value1, value2, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumNotBetween(Integer value1, Integer value2) {
			addCriterion("pro_stock_num not between", value1, value2, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumLike(Integer value) {
			addCriterion("pro_stock_num like", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProStockNumNotLike(Integer value) {
			addCriterion("pro_stock_num not like", value, "proStockNum");
			return (Criteria) this;
		}
		public Criteria andProIntroIsNull() {
			addCriterion("pro_intro is null");
			return (Criteria) this;
		}
		public Criteria andProIntroIsNotNull(){
			addCriterion("pro_intro is not null");
			return (Criteria) this;
		}
		public Criteria andProIntroEqualTo(String value) {
			addCriterion("pro_intro =", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroNotEqualTo(String value) {
			addCriterion("pro_intro <>", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroGreaterThan(String value) {
			addCriterion("pro_intro >", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroGreaterThanOrEqualTo(String value) {
			addCriterion("pro_intro >=", value, "ProIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroLessThan(String value) {
			addCriterion("pro_intro <", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroLessThanOrEqualTo(String value) {
			addCriterion("pro_intro <=", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroIn(List<String> values) {
			addCriterion("pro_intro in", values, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroNotIn(List<String> values) {
			addCriterion("pro_intro not in", values, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroBetween(String value1, String value2) {
			addCriterion("pro_intro between", value1, value2, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroNotBetween(String value1, String value2) {
			addCriterion("pro_intro not between", value1, value2, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroLike(String value) {
			addCriterion("pro_intro like", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProIntroNotLike(String value) {
			addCriterion("pro_intro not like", value, "proIntro");
			return (Criteria) this;
		}
		public Criteria andProDetailIsNull() {
			addCriterion("pro_detail is null");
			return (Criteria) this;
		}
		public Criteria andProDetailIsNotNull(){
			addCriterion("pro_detail is not null");
			return (Criteria) this;
		}
		public Criteria andProDetailEqualTo(String value) {
			addCriterion("pro_detail =", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailNotEqualTo(String value) {
			addCriterion("pro_detail <>", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailGreaterThan(String value) {
			addCriterion("pro_detail >", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailGreaterThanOrEqualTo(String value) {
			addCriterion("pro_detail >=", value, "ProDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailLessThan(String value) {
			addCriterion("pro_detail <", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailLessThanOrEqualTo(String value) {
			addCriterion("pro_detail <=", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailIn(List<String> values) {
			addCriterion("pro_detail in", values, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailNotIn(List<String> values) {
			addCriterion("pro_detail not in", values, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailBetween(String value1, String value2) {
			addCriterion("pro_detail between", value1, value2, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailNotBetween(String value1, String value2) {
			addCriterion("pro_detail not between", value1, value2, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailLike(String value) {
			addCriterion("pro_detail like", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andProDetailNotLike(String value) {
			addCriterion("pro_detail not like", value, "proDetail");
			return (Criteria) this;
		}
		public Criteria andSaleNumIsNull() {
			addCriterion("sale_num is null");
			return (Criteria) this;
		}
		public Criteria andSaleNumIsNotNull(){
			addCriterion("sale_num is not null");
			return (Criteria) this;
		}
		public Criteria andSaleNumEqualTo(Integer value) {
			addCriterion("sale_num =", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumNotEqualTo(Integer value) {
			addCriterion("sale_num <>", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumGreaterThan(Integer value) {
			addCriterion("sale_num >", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("sale_num >=", value, "SaleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumLessThan(Integer value) {
			addCriterion("sale_num <", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumLessThanOrEqualTo(Integer value) {
			addCriterion("sale_num <=", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumIn(List<Integer> values) {
			addCriterion("sale_num in", values, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumNotIn(List<Integer> values) {
			addCriterion("sale_num not in", values, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumBetween(Integer value1, Integer value2) {
			addCriterion("sale_num between", value1, value2, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumNotBetween(Integer value1, Integer value2) {
			addCriterion("sale_num not between", value1, value2, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumLike(Integer value) {
			addCriterion("sale_num like", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andSaleNumNotLike(Integer value) {
			addCriterion("sale_num not like", value, "saleNum");
			return (Criteria) this;
		}
		public Criteria andIsUpIsNull() {
			addCriterion("is_up is null");
			return (Criteria) this;
		}
		public Criteria andIsUpIsNotNull(){
			addCriterion("is_up is not null");
			return (Criteria) this;
		}
		public Criteria andIsUpEqualTo(Integer value) {
			addCriterion("is_up =", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpNotEqualTo(Integer value) {
			addCriterion("is_up <>", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpGreaterThan(Integer value) {
			addCriterion("is_up >", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_up >=", value, "IsUp");
			return (Criteria) this;
		}
		public Criteria andIsUpLessThan(Integer value) {
			addCriterion("is_up <", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpLessThanOrEqualTo(Integer value) {
			addCriterion("is_up <=", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpIn(List<Integer> values) {
			addCriterion("is_up in", values, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpNotIn(List<Integer> values) {
			addCriterion("is_up not in", values, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpBetween(Integer value1, Integer value2) {
			addCriterion("is_up between", value1, value2, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpNotBetween(Integer value1, Integer value2) {
			addCriterion("is_up not between", value1, value2, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpLike(Integer value) {
			addCriterion("is_up like", value, "isUp");
			return (Criteria) this;
		}
		public Criteria andIsUpNotLike(Integer value) {
			addCriterion("is_up not like", value, "isUp");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
