package com.market.dao;
import com.market.model.OrderMsg;
import com.market.model.OrderMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface OrderMsgMapper {
	long countByExample(OrderMsgExample example);
	int deleteByExample(OrderMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(OrderMsg record);
	int insertSelective(OrderMsg record);
	List<OrderMsg> selectByExample(OrderMsgExample example);
	OrderMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") OrderMsg record, @Param("example") OrderMsgExample example);
	int updateByExample(@Param("record") OrderMsg record, @Param("example") OrderMsgExample example);
	int updateByPrimaryKeySelective(OrderMsg record);
	int updateByPrimaryKey(OrderMsg record);
}
