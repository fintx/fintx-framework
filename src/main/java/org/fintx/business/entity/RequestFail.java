package org.fintx.business.entity;

public class RequestFail {
    private Long id;

    private String orgcode;

    private String productno;

    private String channelcode;

    private String bizcode;

    private String channeldate;

    private String channelbizsn;

    private String data;

    private String msgcode;

    private String msgdesc;

    private String url;

    private Boolean status;
    
    /**
     * 自定义构造函数
     * @param orgcode 机构号
     * @param productno 产品号
     * @param channelcode 渠道号
     * @param bizcode 业务码
     * @param channeldate 渠道账期
     * @param channelbizsn 渠道流水号
     * @param data 请求数据
     * @param msgcode 消息码
     * @param msgdesc 消息描述
     * @param url 请求地址
     */
    public RequestFail(String orgcode, String productno, String channelcode, String bizcode, String channeldate,
			String channelbizsn, String data, String msgcode, String msgdesc, String url) {
		super();
		this.orgcode = orgcode;
		this.productno = productno;
		this.channelcode = channelcode;
		this.bizcode = bizcode;
		this.channeldate = channeldate;
		this.channelbizsn = channelbizsn;
		this.data = data;
		this.msgcode = msgcode;
		this.msgdesc = msgdesc;
		this.url = url;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode;
    }

    public String getBizcode() {
        return bizcode;
    }

    public void setBizcode(String bizcode) {
        this.bizcode = bizcode;
    }

    public String getChanneldate() {
        return channeldate;
    }

    public void setChanneldate(String channeldate) {
        this.channeldate = channeldate;
    }

    public String getChannelbizsn() {
        return channelbizsn;
    }

    public void setChannelbizsn(String channelbizsn) {
        this.channelbizsn = channelbizsn;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }

    public String getMsgdesc() {
        return msgdesc;
    }

    public void setMsgdesc(String msgdesc) {
        this.msgdesc = msgdesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}