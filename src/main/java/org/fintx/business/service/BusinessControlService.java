
package org.fintx.business.service;

import org.fintx.business.entity.BusinessControl;


public interface BusinessControlService {
    public Boolean controlRepetition(BusinessControl biz);
    public Boolean resetRepeatable(BusinessControl biz);
}
