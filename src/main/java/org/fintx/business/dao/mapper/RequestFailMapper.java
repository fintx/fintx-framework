package org.fintx.business.dao.mapper;


import org.fintx.business.entity.RequestFail;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RequestFailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RequestFail record);

    int insertSelective(RequestFail record);

    RequestFail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RequestFail record);

    int updateByPrimaryKey(RequestFail record);
}