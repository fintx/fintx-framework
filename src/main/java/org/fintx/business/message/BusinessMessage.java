
package org.fintx.business.message;

import org.fintx.message.Message;

public enum BusinessMessage implements Message<String>{
    BC10000000I("success"), BC11111111I("处理�?"),BC99999999E("fail"),BC11111111E("{0}请求参数为空"),BC11111112I("{BC19000001I:方法�?始执行}"),
    BC11111113I("{BC19000002I:方法执行结束}"),BC11111114E("{BC19900001E:方法执行出现异常信息}"),BC11111115E("{BC19900002E:未查到记录}");

    private String desc;
    private BusinessMessage(String desc){
        this.desc=desc;
    }
    
    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
