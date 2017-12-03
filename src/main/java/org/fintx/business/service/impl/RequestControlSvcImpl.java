package org.fintx.business.service.impl;

import javax.annotation.Resource;

import org.fintx.business.dao.RequestControlDao;
import org.fintx.business.entity.RequestControl;
import org.fintx.business.service.RequestControlService;
import org.springframework.stereotype.Service;

@Service
public class RequestControlSvcImpl implements RequestControlService {

	@Resource
	private RequestControlDao requestControlDao;
	/**
	 * 
	 * @Description: 添加RequestControl
	 * 2017年5月14日
	 */
	@Override
	public Boolean controlRepetition(RequestControl requestControl) {
		try {
			return requestControlDao.save(requestControl);			
		} catch (Exception e) {
			// 请求校验时，没有入库成功
			return false;
		}
	}

}
