package org.fintx.lang;



import org.fintx.enumeration.Layer;
import org.fintx.message.Message;

import lombok.Getter;

@Getter
public class FintxError extends Error implements Message<String> {
    /** 序列化ID */
    private static final long serialVersionUID = 8262974144769618634L;
    
    private String code;
    private String desc;
    private String module;
    private Layer layer;
 
 
    /**
     * 自定义异�?
     * 
     * @param message 异常信息
     * @param errorCode 异常�?
     */
    public FintxError(String module,Layer layer,Message<String> msg) {
        this.module=module;
        this.layer=layer;
        this.code=msg.getCode();
        this.desc=msg.getDesc();
    }
    /**
     * 自定义异�?
     * 
     * @param message 异常信息
     * @param errorCode 异常�?
     */
    public FintxError(String module,Layer layer,Message<String> msg,Throwable t) {
        super(t);
        this.module=module;
        this.layer=layer;
        this.code=msg.getCode();
        this.desc=msg.getDesc();
    }




}
