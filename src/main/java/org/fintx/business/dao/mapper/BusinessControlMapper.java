package org.fintx.business.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.fintx.business.entity.BusinessControl;

@Mapper
public interface BusinessControlMapper {

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
    int insert(BusinessControl record);

    /**
     * 根据主键获取一条数据库记录
     * @param id
     * @mbg.generated
     */
    BusinessControl selectByPrimaryKey(Long id);

    /**
     * 获取全部数据库记录
     * @mbg.generated
     */
    List<BusinessControl> selectAll();

    /**
     * 根据主键来更新数据库记录
     * @param record
     * @mbg.generated
     */
    int updateByPrimaryKey(BusinessControl record);

    /**
	 * 
	 * @Title: deleteByMap 
	 * @Description: 根据map删除BusinessControl数据
	 * @param map
	 * @return
	 * 2017年5月14日
	 */
	int deleteByMap(Map<String, Object> map);

}