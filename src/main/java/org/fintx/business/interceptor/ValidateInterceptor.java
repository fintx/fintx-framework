package org.fintx.business.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.fintx.business.BusinessDTO;
import org.fintx.business.message.BusinessMessage;
import org.fintx.message.DetailMessage;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class ValidateInterceptor {

	/**
	 * <pre>
	 * Description:
	 *  service 拦截器，用于执行service方法之前进行入参校验
	 * </pre>
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "execution (* org.fintx.business.Business.process(..))")
	public Object validate(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
		
		Object result = null;
		BusinessDTO<?> dto = null;
		
		// 遍历参数校验字段
		dto = (BusinessDTO) pjp.getArgs()[0];



        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Map<String, String> errorMap = new HashMap<>();
        
        // 1.校验BusinessVo中的【基本类型】字段
        // 【注意，validator仅仅只能校验BusinessVo中基本类型的字段，不能校验引用类型的字段】
        Set<ConstraintViolation<Object>> validateSet = validator.validate(dto);
        for (ConstraintViolation<Object> cv : validateSet) {
            errorMap.put(cv.getPropertyPath().toString(), String.format("字段：%1$s；值：%2$s；错误信息：%3$s",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
            
        }
        // 2.校验BusinessVo中的【引用类型】字段所代表的业务数据对象中的字段，比如SignatureData中的字段，能否为空
        if( dto.getData() != null ){
            Object data = dto.getData();
            Set<ConstraintViolation<Object>> validateSet02 = validator.validate(data);
            for (ConstraintViolation<Object> cv : validateSet02) {
                errorMap.put(cv.getPropertyPath().toString(), String.format("字段：%1$s；值：%2$s；错误信息：%3$s",
                        cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
                
            }               
        }
        
        // 校验失败返回
        if (!errorMap.isEmpty()) {
            DetailMessage<String> msg=new DetailMessage<String>(BusinessMessage.BC11111111E);
            for(Entry<?, ?> e:errorMap.entrySet()){
                msg.setDetail(msg.getDetail()+";"+e.getValue());
            }
            dto.setResult(msg);
            result = dto;
        } else {
            // 校验通过执行目标方法
            result = pjp.proceed();
        }
		
		return result;
	}
}
