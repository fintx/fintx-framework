package org.fintx.business.interceptor;





import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class RequestFailInterceptor {
	//RequestFailService requestFailService;
   

    
    /**
     * @Title: getRequsetMessage
     * @Description:获取请求消息体
     * @param point
     * @return 请求消息map
     *//*
    private  String getRequsetMessage(JoinPoint point) {
        String message = new String();
        for (Object obj : point.getArgs()) {
            if (obj instanceof String) {
                message = (String) obj;
                break;
            }
        }
      
        return message;
    }

    *//**
     * @Title: before
     * @Description: 被拦截方法执行前,此方法被调用
     * @param point
     * @throws Throwable
     *//*
    //@Before(value = "execution (* com..web.controller..*.*(..))")
	@Before(value = "execution (* org.fintx.common.interceptor..*.*(..))")
    public void before(JoinPoint point) throws Throwable {
    	String requestMessage = getRequsetMessage(point);
    	JSONObject messageObject = JSON.parseObject(requestMessage);
        String functionPath = point.getTarget().getClass().getName() + "." + point.getSignature().getName();
        if (messageObject.isEmpty()) {
            LogUtil.logInterface(new InterfaceArgs("", IPUtil.getRemoteAddress(), "", "", CommonMsg.BC11111111E.toString(), functionPath + CommonMsg.BC11111111E.getDesc()));
        } else {
            LogUtil.logInterface(new InterfaceArgs(messageObject.getJSONObject("header").getString("channelCode"), IPUtil.getRemoteAddress(), messageObject.getJSONObject("header").getString("bizCode"), messageObject.getJSONObject("header").getString("channelBizSN"), CommonMsg.BC11111112I.toString(), "接口参数:" + messageObject.toString() + "\n" + functionPath + CommonMsg.BC11111112I.getDesc()));
        }
    }

    *//**
     * @Title: after
     * @Description:被拦截方法执行后,此方法被调用
     * @param point
     * @throws Throwable
     *//*
    @AfterReturning(value = "execution (* org.fintx.common.interceptor..*.*(..))", returning = "test")
    
    public void afterReturning(JoinPoint point, Object test) throws Throwable {
        String requestMessage = getRequsetMessage(point);
        JSONObject messageObject = JSON.parseObject(requestMessage);
        String functionPath = point.getTarget().getClass().getName() + "." + point.getSignature().getName();
        if (messageObject.isEmpty()) {
            LogUtil.logInterface(new InterfaceArgs("", IPUtil.getRemoteAddress(), "", "", CommonMsg.BC11111111E.toString(), functionPath + CommonMsg.BC11111111E.getDesc()));
        } else {
        	
            LogUtil.logInterface(new InterfaceArgs(messageObject.getJSONObject("header").getString("channelCode"), IPUtil.getRemoteAddress(), messageObject.getJSONObject("header").getString("bizCode"), messageObject.getJSONObject("header").getString("channelBizSN"), CommonMsg.BC11111113I.toString(), "接口参数:" + messageObject.toString() + "\n" + "接口返回：" + JSONObject.toJSONString(test) + functionPath + CommonMsg.BC11111113I.getDesc()));
            JSONObject result = JSON.parseObject(test.toString()).getJSONObject("fault");
       
            //如果返回码不等于success，则将请求信息插入请求失败表
            String code = result.getString("code");//错误码
            String desc = result.getString("desc");//错误描述
           
            if(!code.equals("BC10000000I") && !code.equals("BC11111111E")){
            	String orgCode = messageObject.getJSONObject("header").getString("orgCode");
            	String productNo = messageObject.getJSONObject("header").getString("productNo");
            	String channelCode = messageObject.getJSONObject("header").getString("channelCode");
            	String bizCode = messageObject.getJSONObject("header").getString("bizCode");
            	String channelDate = messageObject.getJSONObject("header").getString("channelDate");
            	String channelBizSN = messageObject.getJSONObject("header").getString("channelBizSN");
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String requestUrl = request.getRequestURL().toString();
            	
            	//RequestFail requestFail = new RequestFail(orgCode, productNo, channelCode, bizCode, channelDate, channelBizSN, requestMessage,code,desc,requestUrl);
                //插入异常信息
            	//requestFailService.add(requestFail);
            }
        }
    }

    *//**
     * @Title: afterThrowing
     * @Description:被拦截方法执行后,此方法被调用
     * @param point
     * @param e
     *//*
    @AfterThrowing(value = "execution (* org.fintx.common.interceptor..*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint point, Throwable e) {
        String requestMessage = getRequsetMessage(point);
        JSONObject messageObject = JSON.parseObject(requestMessage);
        String functionPath = point.getTarget().getClass().getName() + "." + point.getSignature().getName();
        if (requestMessage.isEmpty()) {
            LogUtil.logInterface(new InterfaceArgs("", IPUtil.getRemoteAddress(), "", "", CommonMsg.BC11111111E.toString(), functionPath + CommonMsg.BC11111111E.getDesc()));
        } else {
            LogUtil.logInterface(new InterfaceArgs(messageObject.getJSONObject("header").get("channelCode").toString(), IPUtil.getRemoteAddress(), messageObject.getJSONObject("header").get("bizCode").toString(), messageObject.getJSONObject("header").get("channelBizSN").toString(), CommonMsg.BC11111114E.getCode(), "接口参数:" + messageObject.toString() + "\n" + functionPath + CommonMsg.BC11111114E.getDesc()));
        }
    }*/
}
