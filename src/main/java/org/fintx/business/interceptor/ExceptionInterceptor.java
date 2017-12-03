package org.fintx.business.interceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.fintx.business.message.BusinessMessage;
import org.fintx.enumeration.Module;
import org.fintx.lang.FintxError;
import org.fintx.lang.FintxException;
import org.fintx.logging.LogMessage;
import org.fintx.message.DetailMessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



/**
 * <pre>
 * <p>
 * Description:
 *  配置一个环绕切面,统一处理异常
 * </p>
 * </pre>
 * 
 */
@Component
@Aspect
public class ExceptionInterceptor {
    
    /**
     * 环绕通知，记录目标函数执行情况，处理所有异常
     * 
     * @param pjp
     * @return 目标方法执行
     * @throws Throwable 非自定义异常，抛出
     */
    @Around(value = "execution (* org.fintx.remoting.BusinessRemoting.*(..))")    
    public Object doAround(ProceedingJoinPoint pjp) {
    	
		String fullMethodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();

        long starttime = System.currentTimeMillis();

        String result = "";
        DetailMessage<String> errorMsg=new DetailMessage<String>();
        boolean isSuccess = false;
        // 截取Controller的入参
        StringBuffer req = new StringBuffer("");
        //StringBuffer rpsb = new StringBuffer("返回结果:");
        JSONObject obj = new JSONObject();
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            // 获取调用请求参数
            if (arg instanceof String) {
                req.append(((String) arg).replaceAll("\\s", ""));
            }
        }
        
        try {
            if (req != null) {
                //LogUtil.logInfo(BusinessRemoting.class, "请求报文：" + req.toString());
            }
            result = pjp.proceed().toString();
            //obj = JSON.parseObject(result);
            //rpsb.append(obj);
            // 处理成功
            isSuccess = true;
        } catch (FintxException e) {
            errorMsg.setMessage(e);
            errorMsg.setDetail( e.getMessage() );
            result="{\"result\":"+JSON.toJSONString(errorMsg)+"}";
        } catch (FintxError e) {
            errorMsg.setMessage(e);
            errorMsg.setDesc( e.getMessage() );
            result="{\"result\":"+JSON.toJSONString(errorMsg)+"}";
        } catch (Throwable e) {
        	LogMessage messageArgs = new LogMessage(Module.BUSINESS, BusinessMessage.BC99999999E);
            errorMsg.setMessage(messageArgs);
        	errorMsg.setDetail( e.getMessage() );
            result="{\"result\":"+JSON.toJSONString(errorMsg)+"}";
        }
       
        return result;
    }
}
