package org.fintx.business;

import java.io.Serializable;
import java.time.ZoneId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import org.fintx.message.Message;

import com.alibaba.fastjson.annotation.JSONType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JSONType(orders = { "version", "bizCode", "reqId", "respId", "appId","appDate", "timestamp","expire", "sourceIp", "signType", "sign", "data", "result" })
// TODO 1 reqId的使用（方便作为标识查找处理的业务，结果会返回请求的reqId） 2对trace的支持 方式（附加信息extend中添加）
// 3内部唯一Id是否必要（必要，作为请求其他系统的reqId/bizId,防止由于原Id长度问题无法使用）
// TODO 4result 增加bizDate bizSn 更新时间戳timstamp
public class BusinessDTO<B> implements Serializable {
    private static final long serialVersionUID = -3289263908424536888L;
    /**
     * api 版本
     */
    // TODO 要检查 只允许 当前版本 和上一版本的版本号
    @NotBlank(message="version不能为空")
    @Pattern(regexp = "^1\\.0$", message = "version版本必须为1.0")
    private String version = null;
    /**
     * 业务码 Signature/SignatureQuery/Charging/ChargingQuery/Refunding/Transfering
     */
    @NotBlank(message="bizCode不能为空")
    private String businessCode = null;
    /**
     * 请求流水号（每次请求唯一）
     */
    @NotBlank(message="requestId不能为空")
    @Length(max=32)
    private String reqId = null;
    
    /**
     * 请求流水号（每次请求唯一）
     */
    @NotBlank(message="responseId不能为空")
    @Length(max=32)
    private String responseId = null;
    
    // /**
    // * 业务ID所在键
    // */
    // private String bizId = null;
    // /**
    // * 业务日期
    // */
    // private String bizDate = null;

    /**
     * 接入应用ID 按appid去申请密钥进行签名
     */
    @NotBlank(message="applicationId不能为空")
    @Length(max=32)
    private String applicationId;

    /**
     * 发起端IP
     */
    @NotBlank(message="sourceIp不能为空")
    @Pattern(regexp="([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}",message="sourceIp不符合Ip格式")
    private String sourceIp;
    
    /**
     * 发起端IP
     */
    @NotBlank(message="targetIp不能为空")
    @Pattern(regexp="([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}",message="sourceIp不符合Ip格式")
    private String targetIp;


    // /**
    // * 支付渠道ID：浦发 /广发/招商/支付宝
    // */
    // @Length(max = 8)
    // private String channelId;
    //
    // /**
    // * 支付类型//快捷 签约
    // */
    // @Length(max = 8)
    // private String paymentType;
    //
    // /**
    // * 商户ID
    // */
    // @Length(max = 8)
    // private String mercId;
    // /**
    // * 会员ID
    // */
    // @Length(max = 20)
    // private String userId;
    /**
     * 签名类型
     */
    private String signType;
    /**
     * 数字签名
     */
    private String sign;
    /**
     * app日期 不可以与txnDate差距 超过+-1天，可以设置检验时间 如 12点之前  18点之后 appDate是未来Journal分表依据
     */
    @NotBlank(message="appDate不能为空")
    private String appDate;
    /**
     * 系统时间毫秒数
     */
    //(@)NotBlank(message="timestamp不能为空")
    //(@)Digits(fraction = 0, integer = 13)
    @NotNull(message="timestamp不能为空")
    private Long timestamp;
    
//??private ZonedDateTime timestamp;

    /**
     * 渠道失效时间 0---不超时
     */
//    @NotBlank(message="expire不能为空")
    @NotNull(message="expire不能为空")
    private Long expire;
    
    /**
     * 或者
     */
    private ZoneId zone;
    /**
     * 或者
     */
    private String country;
    private String area;
    // /**
    // * 撤销标志
    // */
    // @NotBlank
    // @Pattern(regexp = "[1,0]")
    // private String cancelFlag;
    // /**
    // * 被撤销的流水号
    // */
    // private String cancelBizSN;
    private B data;
/**
 * 抽象类型不会被反序列化，保护数据不会被传入
 */
    private Message<String> result;
}