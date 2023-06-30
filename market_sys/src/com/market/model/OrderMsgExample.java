package com.market.model;
import java.util.ArrayList;
import java.util.List;
public class OrderMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public OrderMsgExample() {
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
		public Criteria andOrderNoIsNull() {
			addCriterion("order_no is null");
			return (Criteria) this;
		}
		public Criteria andOrderNoIsNotNull(){
			addCriterion("order_no is not null");
			return (Criteria) this;
		}
		public Criteria andOrderNoEqualTo(String value) {
			addCriterion("order_no =", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoNotEqualTo(String value) {
			addCriterion("order_no <>", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoGreaterThan(String value) {
			addCriterion("order_no >", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
			addCriterion("order_no >=", value, "OrderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoLessThan(String value) {
			addCriterion("order_no <", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoLessThanOrEqualTo(String value) {
			addCriterion("order_no <=", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoIn(List<String> values) {
			addCriterion("order_no in", values, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoNotIn(List<String> values) {
			addCriterion("order_no not in", values, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoBetween(String value1, String value2) {
			addCriterion("order_no between", value1, value2, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoNotBetween(String value1, String value2) {
			addCriterion("order_no not between", value1, value2, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoLike(String value) {
			addCriterion("order_no like", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andOrderNoNotLike(String value) {
			addCriterion("order_no not like", value, "orderNo");
			return (Criteria) this;
		}
		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}
		public Criteria andUidIsNotNull(){
			addCriterion("uid is not null");
			return (Criteria) this;
		}
		public Criteria andUidEqualTo(Integer value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotEqualTo(Integer value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThan(Integer value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uid >=", value, "Uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThan(Integer value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThanOrEqualTo(Integer value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidIn(List<Integer> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotIn(List<Integer> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidBetween(Integer value1, Integer value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotBetween(Integer value1, Integer value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLike(Integer value) {
			addCriterion("uid like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotLike(Integer value) {
			addCriterion("uid not like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUrealNameIsNull() {
			addCriterion("ureal_name is null");
			return (Criteria) this;
		}
		public Criteria andUrealNameIsNotNull(){
			addCriterion("ureal_name is not null");
			return (Criteria) this;
		}
		public Criteria andUrealNameEqualTo(String value) {
			addCriterion("ureal_name =", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotEqualTo(String value) {
			addCriterion("ureal_name <>", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameGreaterThan(String value) {
			addCriterion("ureal_name >", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameGreaterThanOrEqualTo(String value) {
			addCriterion("ureal_name >=", value, "UrealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLessThan(String value) {
			addCriterion("ureal_name <", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLessThanOrEqualTo(String value) {
			addCriterion("ureal_name <=", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameIn(List<String> values) {
			addCriterion("ureal_name in", values, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotIn(List<String> values) {
			addCriterion("ureal_name not in", values, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameBetween(String value1, String value2) {
			addCriterion("ureal_name between", value1, value2, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotBetween(String value1, String value2) {
			addCriterion("ureal_name not between", value1, value2, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLike(String value) {
			addCriterion("ureal_name like", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotLike(String value) {
			addCriterion("ureal_name not like", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIsNull() {
			addCriterion("ucel_phone is null");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIsNotNull(){
			addCriterion("ucel_phone is not null");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneEqualTo(String value) {
			addCriterion("ucel_phone =", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotEqualTo(String value) {
			addCriterion("ucel_phone <>", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneGreaterThan(String value) {
			addCriterion("ucel_phone >", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("ucel_phone >=", value, "UcelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLessThan(String value) {
			addCriterion("ucel_phone <", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLessThanOrEqualTo(String value) {
			addCriterion("ucel_phone <=", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIn(List<String> values) {
			addCriterion("ucel_phone in", values, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotIn(List<String> values) {
			addCriterion("ucel_phone not in", values, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneBetween(String value1, String value2) {
			addCriterion("ucel_phone between", value1, value2, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotBetween(String value1, String value2) {
			addCriterion("ucel_phone not between", value1, value2, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLike(String value) {
			addCriterion("ucel_phone like", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotLike(String value) {
			addCriterion("ucel_phone not like", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUaddressIsNull() {
			addCriterion("uaddress is null");
			return (Criteria) this;
		}
		public Criteria andUaddressIsNotNull(){
			addCriterion("uaddress is not null");
			return (Criteria) this;
		}
		public Criteria andUaddressEqualTo(String value) {
			addCriterion("uaddress =", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressNotEqualTo(String value) {
			addCriterion("uaddress <>", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressGreaterThan(String value) {
			addCriterion("uaddress >", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressGreaterThanOrEqualTo(String value) {
			addCriterion("uaddress >=", value, "Uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressLessThan(String value) {
			addCriterion("uaddress <", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressLessThanOrEqualTo(String value) {
			addCriterion("uaddress <=", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressIn(List<String> values) {
			addCriterion("uaddress in", values, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressNotIn(List<String> values) {
			addCriterion("uaddress not in", values, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressBetween(String value1, String value2) {
			addCriterion("uaddress between", value1, value2, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressNotBetween(String value1, String value2) {
			addCriterion("uaddress not between", value1, value2, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressLike(String value) {
			addCriterion("uaddress like", value, "uaddress");
			return (Criteria) this;
		}
		public Criteria andUaddressNotLike(String value) {
			addCriterion("uaddress not like", value, "uaddress");
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
		public Criteria andPproPriceIsNull() {
			addCriterion("ppro_price is null");
			return (Criteria) this;
		}
		public Criteria andPproPriceIsNotNull(){
			addCriterion("ppro_price is not null");
			return (Criteria) this;
		}
		public Criteria andPproPriceEqualTo(Double value) {
			addCriterion("ppro_price =", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceNotEqualTo(Double value) {
			addCriterion("ppro_price <>", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceGreaterThan(Double value) {
			addCriterion("ppro_price >", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceGreaterThanOrEqualTo(Double value) {
			addCriterion("ppro_price >=", value, "PproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceLessThan(Double value) {
			addCriterion("ppro_price <", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceLessThanOrEqualTo(Double value) {
			addCriterion("ppro_price <=", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceIn(List<Double> values) {
			addCriterion("ppro_price in", values, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceNotIn(List<Double> values) {
			addCriterion("ppro_price not in", values, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceBetween(Double value1, Double value2) {
			addCriterion("ppro_price between", value1, value2, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceNotBetween(Double value1, Double value2) {
			addCriterion("ppro_price not between", value1, value2, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceLike(Double value) {
			addCriterion("ppro_price like", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andPproPriceNotLike(Double value) {
			addCriterion("ppro_price not like", value, "pproPrice");
			return (Criteria) this;
		}
		public Criteria andOrderNumIsNull() {
			addCriterion("order_num is null");
			return (Criteria) this;
		}
		public Criteria andOrderNumIsNotNull(){
			addCriterion("order_num is not null");
			return (Criteria) this;
		}
		public Criteria andOrderNumEqualTo(Integer value) {
			addCriterion("order_num =", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumNotEqualTo(Integer value) {
			addCriterion("order_num <>", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumGreaterThan(Integer value) {
			addCriterion("order_num >", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_num >=", value, "OrderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumLessThan(Integer value) {
			addCriterion("order_num <", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
			addCriterion("order_num <=", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumIn(List<Integer> values) {
			addCriterion("order_num in", values, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumNotIn(List<Integer> values) {
			addCriterion("order_num not in", values, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumBetween(Integer value1, Integer value2) {
			addCriterion("order_num between", value1, value2, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
			addCriterion("order_num not between", value1, value2, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumLike(Integer value) {
			addCriterion("order_num like", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andOrderNumNotLike(Integer value) {
			addCriterion("order_num not like", value, "orderNum");
			return (Criteria) this;
		}
		public Criteria andTotalAmountIsNull() {
			addCriterion("total_amount is null");
			return (Criteria) this;
		}
		public Criteria andTotalAmountIsNotNull(){
			addCriterion("total_amount is not null");
			return (Criteria) this;
		}
		public Criteria andTotalAmountEqualTo(String value) {
			addCriterion("total_amount =", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountNotEqualTo(String value) {
			addCriterion("total_amount <>", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountGreaterThan(String value) {
			addCriterion("total_amount >", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountGreaterThanOrEqualTo(String value) {
			addCriterion("total_amount >=", value, "TotalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountLessThan(String value) {
			addCriterion("total_amount <", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountLessThanOrEqualTo(String value) {
			addCriterion("total_amount <=", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountIn(List<String> values) {
			addCriterion("total_amount in", values, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountNotIn(List<String> values) {
			addCriterion("total_amount not in", values, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountBetween(String value1, String value2) {
			addCriterion("total_amount between", value1, value2, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountNotBetween(String value1, String value2) {
			addCriterion("total_amount not between", value1, value2, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountLike(String value) {
			addCriterion("total_amount like", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andTotalAmountNotLike(String value) {
			addCriterion("total_amount not like", value, "totalAmount");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIsNull() {
			addCriterion("order_status is null");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIsNotNull(){
			addCriterion("order_status is not null");
			return (Criteria) this;
		}
		public Criteria andOrderStatusEqualTo(Integer value) {
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotEqualTo(Integer value) {
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusGreaterThan(Integer value) {
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_status >=", value, "OrderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLessThan(Integer value) {
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIn(List<Integer> values) {
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotIn(List<Integer> values) {
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_status not between", value1, value2, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLike(Integer value) {
			addCriterion("order_status like", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotLike(Integer value) {
			addCriterion("order_status not like", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andPayAmountIsNull() {
			addCriterion("pay_amount is null");
			return (Criteria) this;
		}
		public Criteria andPayAmountIsNotNull(){
			addCriterion("pay_amount is not null");
			return (Criteria) this;
		}
		public Criteria andPayAmountEqualTo(Double value) {
			addCriterion("pay_amount =", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountNotEqualTo(Double value) {
			addCriterion("pay_amount <>", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountGreaterThan(Double value) {
			addCriterion("pay_amount >", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountGreaterThanOrEqualTo(Double value) {
			addCriterion("pay_amount >=", value, "PayAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountLessThan(Double value) {
			addCriterion("pay_amount <", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountLessThanOrEqualTo(Double value) {
			addCriterion("pay_amount <=", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountIn(List<Double> values) {
			addCriterion("pay_amount in", values, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountNotIn(List<Double> values) {
			addCriterion("pay_amount not in", values, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountBetween(Double value1, Double value2) {
			addCriterion("pay_amount between", value1, value2, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountNotBetween(Double value1, Double value2) {
			addCriterion("pay_amount not between", value1, value2, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountLike(Double value) {
			addCriterion("pay_amount like", value, "payAmount");
			return (Criteria) this;
		}
		public Criteria andPayAmountNotLike(Double value) {
			addCriterion("pay_amount not like", value, "payAmount");
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
