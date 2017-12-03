package org.fintx.business.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.fintx.business.dao.RequestControlDao;
import org.fintx.business.dao.mapper.RequestControlMapper;
import org.fintx.business.entity.RequestControl;

import org.springframework.stereotype.Repository;
@Repository
public class RequestControlDaoImpl implements RequestControlDao{

	@Resource
	private RequestControlMapper requestControlMapper;
	@Override
	public boolean save(RequestControl record) {
		int addRequestControl = requestControlMapper.insert(record);
		if(addRequestControl > 0 ){
			return true;
		}
		return false;
	}

	@Override
	public RequestControl get(RequestControl record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(RequestControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(RequestControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RequestControl> listAll(RequestControl record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveAll(List<RequestControl> records) {
		// TODO Auto-generated method stub
		return 0;
	}

}
