package org.fintx.share.dao.mapper;


import org.fintx.sequence.entity.Sequence;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SequenceMapper {
	int deleteByPrimaryKey(String name);

	int insert(Sequence record);

	int insertSelective(Sequence record);

	Sequence selectByPrimaryKey(String name);

	int updateByPrimaryKeySelective(Sequence record);

	int updateByPrimaryKey(Sequence record);

	String selectNextValueByName(String name);
}