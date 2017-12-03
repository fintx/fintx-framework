package org.fintx.logging;


import org.fintx.message.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 日志工具类的接口日志参数类�??
 * <p>
 *
 * 创建日期 2015�?8�?26�?<br>
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceArgs{
    private String code;
    private String desc;
    private String oReqId;
    private String oAppDate;
    private String oAppId;
    private String txnSn;
    private String txnDate;
  
    // 调用者IP
    private String sourceIp;
   
   
    /**
     * 接口日志参数
     * 
     * @param cc 调用者应用编�?
     * @param ci 调用者IP
     * @param bn 业务�?
     * @param en 外部业务流水�?
     * @param mc 消息编码
     * @param md 消息内容
     */
    public InterfaceArgs(String sourceIp,String txnSn,String txnDate,String oReqId,String oAppDate,String oAppId,Message msg) {
       this.sourceIp=sourceIp;
       this.setTxnSn(txnSn);
       this.setTxnDate(txnDate);
       this.setOAppDate(oAppDate);
       this.setOAppId(oAppId);
       this.setOReqId(oReqId);
       this.setMsg(msg);
    }
    
    public void setMsg(Message<?> msg){
        if(null!=msg){
            this.code=msg.getCode().toString();
            this.desc=msg.getDesc();
        }
       
    }

  

}
