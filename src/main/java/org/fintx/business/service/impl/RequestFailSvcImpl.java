package org.fintx.business.service.impl;

import org.fintx.business.dao.RequestFailDao;
import org.fintx.business.entity.RequestFail;
import org.fintx.business.service.RequestFailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestFailSvcImpl implements RequestFailService {
    @Autowired
    private RequestFailDao requestFailDao;

    @Override
    public int add(RequestFail request) {
        return requestFailDao.add(request);
    }

}
