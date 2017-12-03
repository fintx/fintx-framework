package org.fintx.business.dao.mapper;

import java.util.List;

import org.fintx.business.entity.RequestControl;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestControlMapper {

    /**
     * 根据主键删除数据库的记录
     * @param id
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     * @param record
     * @mbg.generated
     */
    int insert(RequestControl record);

    /**
     * 根据主键获取一条数据库记录
     * @param id
     * @mbg.generated
     */
    RequestControl selectByPrimaryKey(Long id);

    /**
     * 获取全部数据库记录
     * @mbg.generated
     */
    List<RequestControl> selectAll();

    /**
     * 根据主键来更新数据库记录
     * @param record
     * @mbg.generated
     */
    int updateByPrimaryKey(RequestControl record);
}