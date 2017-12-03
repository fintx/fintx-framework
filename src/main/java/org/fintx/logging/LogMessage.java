package org.fintx.logging;

import org.fintx.enumeration.Module;
import org.fintx.message.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 消息日志/错误消息日志: [模块枚举] [业务号] [业务ID] [交易号] [交易流水号] [消息枚举]�?
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogMessage implements Message<String> {
    private String code;
    private String desc;
    private String oReqId;
    private String oAppDate;
    private String oAppId;
    private String txnSn;
    private String txnDate;
    /**
     * 模块代号
     */
    private String module;

    /**
     * �?般消息，构�?�函数，带参数初始化
     * 
     * @param m 模块代号
     * @param tc 业务�?
     * @param tn 业务流水�?
     * @param dc 交易�?
     * @param dn 交易流水�?
     * @param mc 消息�?
     * @param msg 消息文本
     */

    public LogMessage(Module module, Message msg) {
        this.module = module.name();
        this.setMsg(msg);
    }

    /**
     * �?般消息，构�?�函数，带参数初始化
     * 
     * @param module 模块代号
     * @param bizCode 业务�?
     * @param bizSn 业务流水�?
     * @param txnCode 交易�?
     * @param txnSN 交易流水�?
     * @param msg 消息�?
     * @param msg 消息文本
     */
    public LogMessage(Module module, String txnSn, String txnDate, String oReqId, String oAppDate, String oAppId, Message msg) {
        this.module = module.name();
        this.setTxnSn(txnSn);
        this.setTxnDate(txnDate);
        this.setOAppDate(oAppDate);
        this.setOAppId(oAppId);
        this.setOReqId(oReqId);
        this.setMsg(msg);
    }

    public void setMsg(Message<?> msg) {
        if (null != msg) {
            this.code = msg.getCode().toString();
            this.desc = msg.getDesc();
        }

    }

}
