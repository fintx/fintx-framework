
package org.fintx.business.interceptor;

import org.fintx.business.BusinessDTO;
import org.fintx.business.entity.RequestControl;
import org.fintx.business.message.BusinessMessage;
import org.fintx.business.service.RequestControlService;
import org.fintx.business.util.BusinessUtil;
import org.fintx.message.DetailMessage;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Order(2)
public class RequestControlInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(RequestControlInterceptor.class);
	
	@Autowired
	private RequestControlService requestControlSvc;
	
	@Around(value = "execution (* org.fintx.business.Business.process(..))")
	public Object control(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();

		BusinessDTO<?> dto = null;
		
		dto = (BusinessDTO) pjp.getArgs()[0];
		
		Object result = null;

		if ( true ==  BusinessUtil.isRepeatable( dto.getData() )  ) {
			result = pjp.proceed();
		} 
		else {
			
			// 2.1).校验t_request_controll表中是否已经存在该笔请求记录
			// 通过MySQL的UniqueKey约束来校验，若新的业务数据能入库，则说明数据库中并不存在这笔流水。
			// UniqueKey约束的字段：app_id, app_date, req_id
			RequestControl requestControl = new RequestControl();
			requestControl.setAppId(dto.getApplicationId());
			requestControl.setAppDate(dto.getAppDate());
			requestControl.setReqId(dto.getReqId());
			
			if ( requestControlSvc.controlRepetition(requestControl ) ) {
				result = pjp.proceed();
			} 
			else {
				DetailMessage<String> msg=new DetailMessage(BusinessMessage.BC11111111E);
				
				
				msg.setDetail("该笔【未知】业务没有通过【基础校验(RequestControlInterceptor)】，银行支付系统数据库业务去重控制表(t_request_control表)中已有该笔业务的记录，不能重复！！！"
							+ "前端业务方传入的三要素参数：appId为" + dto.getApplicationId() + "，appDate为" + dto.getAppDate() + "，reqId为" + dto.getReqId() + "，请确认。");
				
				dto.setResult(msg);
				result = dto;			
			}			
			
		}
		
		return result;
	}
}
