package com.market.dao;
import com.market.model.ProMsg;
import com.market.model.ProMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface ProMsgMapper {
	long countByExample(ProMsgExample example);
	int deleteByExample(ProMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(ProMsg record);
	int insertSelective(ProMsg record);
	List<ProMsg> selectByExample(ProMsgExample example);
	ProMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") ProMsg record, @Param("example") ProMsgExample example);
	int updateByExample(@Param("record") ProMsg record, @Param("example") ProMsgExample example);
	int updateByPrimaryKeySelective(ProMsg record);
	int updateByPrimaryKey(ProMsg record);
}
