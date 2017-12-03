package org.fintx.business.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.fintx.business.BusinessDTO;
import org.fintx.business.entity.BusinessControl;
import org.fintx.business.message.BusinessMessage;
import org.fintx.business.service.BusinessControlService;
import org.fintx.business.util.BusinessUtil;
import org.fintx.logging.LogMessage;
import org.fintx.logging.LogUtil;
import org.fintx.message.DetailMessage;
import org.fintx.message.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class BusinessControlInterceptor {

    @Autowired
    private BusinessControlService businessControlSvc;

    @Around(value = "execution (* org.fintx.business.Business.process(..))")
    public Object control(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
        LogUtil.logInfo(BusinessControlInterceptor.class, "在执行【目标方法" + methodName
                + "】之前，进行第三层【BusinessControl的去重】校验，目前在BusinessControlInterceptor拦截器中的checkBusinessExists()方法中，调用目标方法时，传入的参数：pjp.getArgs()[0] = "
                + pjp.getArgs()[0]);

        BusinessDTO<?> dto = null;

        // 遍历参数校验字段
        dto = (BusinessDTO) pjp.getArgs()[0];

        Object result = null;
        if (true == BusinessUtil.isRepeatable(dto.getData())) {
            result = pjp.proceed();
        } else {

            // 1.校验t_business_control表中是否已经存在该笔请求记录
            // 通过MySQL的UniqueKey约束来校验，若新的业务数据能入库，则说明数据库中并不存在这笔流水。
            // UniqueKey约束的字段：app_id, biz_code, biz_date, biz_id
            BusinessControl bizControl = new BusinessControl();
            bizControl.setAppId(dto.getApplicationId());
            bizControl.setBizCode(dto.getBusinessCode());
            String bizDate = BusinessUtil.getBizDate(dto.getData()); // 计算设置biz_date
            bizControl.setBizDate(bizDate); // 设置biz_date
            String bizId = BusinessUtil.getBizId(dto.getData()); // 计算biz_id
            bizControl.setBizId(bizId); // 设置biz_id

            if (businessControlSvc.controlRepetition(bizControl)) {
                result = pjp.proceed();
            }
            // 3.若没有通过BusinessControl去重校验，则封装错误业务编码，并不需要抛出异常。
            else {
                // 把错误封装到统一的返回实体中
                DetailMessage<String> msg = new DetailMessage<String>(BusinessMessage.BC11111111E);
                msg.setDetail("该笔" + dto.getBusinessCode() + "业务没有通过【业务校验(BusinessControlInterceptor)】,已有该笔业务的记录!"
                        + "前端业务方传入的三要素参数：appId为" + dto.getApplicationId() + "，bizCode为" + dto.getBusinessCode() + "，经代扣系统计算后的bizId为" + bizId + "，请确认。");
                dto.setResult(msg);
                result = dto;
            }

        }

        return result;
    }

}
