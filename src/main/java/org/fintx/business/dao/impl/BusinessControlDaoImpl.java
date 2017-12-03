package org.fintx.business.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.fintx.business.dao.BusinessControlDao;
import org.fintx.business.dao.mapper.BusinessControlMapper;
import org.fintx.business.entity.BusinessControl;
import org.springframework.stereotype.Repository;


@Repository
public class BusinessControlDaoImpl implements BusinessControlDao {
    @Resource
    BusinessControlMapper businessControlMapper;

    @Override
    public boolean save(BusinessControl record) {
    	int addBusinessControl = businessControlMapper.insert(record);
    	if(addBusinessControl > 0){
    		 return true;
    	}
    	return false;
    }
    @Override
    public BusinessControl get(BusinessControl record) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int remove(BusinessControl record) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("appId", record.getAppId());
    	map.put("bizCode", record.getBizCode());
    	map.put("bizDate", record.getBizDate());
    	map.put("bizId", record.getBizId());
        return businessControlMapper.deleteByMap(map);
    }

  
}
