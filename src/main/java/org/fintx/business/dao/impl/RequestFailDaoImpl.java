package org.fintx.business.dao.impl;




import org.fintx.business.dao.RequestFailDao;
import org.fintx.business.dao.mapper.RequestFailMapper;
import org.fintx.business.entity.RequestFail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RequestFailDaoImpl implements RequestFailDao {
    @Autowired
    RequestFailMapper sqlMapper;

   
    @Override
    public int add(RequestFail request) {
        // TODO Auto-generated method stub
        return sqlMapper.insert(request);
    }

}
