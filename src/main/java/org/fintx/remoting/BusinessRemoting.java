package org.fintx.remoting;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.fintx.business.Business;
import org.fintx.business.BusinessDTO;
import org.fintx.logging.LogUtil;
import org.fintx.util.SpringContexts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

@Controller
public class BusinessRemoting {

    @Autowired
    private Map<String, Class<?>> bizCodeAndDataClassMap;
    @Autowired
    private Map<String, Class<?>> bizCodeAndBizClassMap;
    @Autowired
    private Map<String, Class<?>> channelAndReceiverClassMap;

    @RequestMapping(path = "/business/{bizCode}", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
    public @ResponseBody String execute(@RequestBody String reqContent, @PathVariable("bizCode") String bizCode) throws Exception {
        // 1.将bizCode的字符串的值的【首字母】转化成【大写】的，比如signature转化成Signature.
        String fistLetter = bizCode.substring(0, 1).toUpperCase();
        String subStr = bizCode.substring(1);
        bizCode = fistLetter + subStr;

        // 2.将前端传来的请求参数转化成BusinessDTO
        BusinessDTO<Object> dto = JSON.parseObject(reqContent, new TypeReference<BusinessDTO<Object>>() {
        });

        // String appId = vo.getAppId();
        // TODO 解密 验签

        Object data = JSON.parseObject(dto.getData().toString(), bizCodeAndDataClassMap.get(bizCode));
        dto.setData(data);

        LogUtil.logInfo(BusinessRemoting.class, " bizCode + \"Biz\" = " + bizCode + "Biz");
        // SpringContextUtil.getBean("name");
        // 只能用name获取，跟代码发现用name获取时似乎有初始化bean的动作，推断用type获取没有去初始化 ，似乎spring bean 是 lazy load 的
        Business<Object, Object> biz =
                (Business<Object, Object>) SpringContexts.getBean(bizCodeAndBizClassMap.get(bizCode).getSimpleName().substring(0, 1).toLowerCase()
                        + bizCodeAndBizClassMap.get(bizCode).getSimpleName().substring(1));

        Object temp = biz.process(dto);
        System.err.println(JSON.toJSONString(temp));
        dto = (BusinessDTO<Object>) temp;

        // TODO 加密 加签
        String resp = JSONObject.toJSONString(dto);

        return resp;
    }

    // 接收行方返回
    @RequestMapping(path = "/receiver/{channel}/{mercNo}/{txnCode}/{txnSn}",
            method = { RequestMethod.POST, RequestMethod.PUT },
            headers = "Accept=*/*;charset=utf-8")
    public @ResponseBody String receive(@RequestBody String reqContent, @PathVariable("channel") String channel,
            @PathVariable("mercNo") String mercNo, @PathVariable("txnCode") String txnCode, @PathVariable("txnSn") String txnSn) throws Exception {
        return null;
    }
}
