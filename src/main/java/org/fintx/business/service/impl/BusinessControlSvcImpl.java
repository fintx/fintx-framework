
package org.fintx.business.service.impl;

import javax.annotation.Resource;

import org.fintx.business.dao.BusinessControlDao;
import org.fintx.business.entity.BusinessControl;
import org.fintx.business.service.BusinessControlService;
import org.springframework.stereotype.Service;


@Service
public class BusinessControlSvcImpl implements BusinessControlService {

	@Resource
	private BusinessControlDao businessControlDao;
    
    @Override
    public Boolean controlRepetition(BusinessControl biz) {
    	try {
    		return businessControlDao.save(biz);
		} catch (Exception e) {
			// 业务校验时，没有入库成功
			return false;
		}
    }

   
    @Override
    public Boolean resetRepeatable(BusinessControl biz) {
		int deleteBusinessControl = businessControlDao.remove(biz);
		if (deleteBusinessControl > 0) {
			return true;
		}
		return false;
    }

}
