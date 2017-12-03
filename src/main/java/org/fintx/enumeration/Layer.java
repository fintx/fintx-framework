package org.fintx.enumeration;

import org.fintx.message.Message;

public enum Layer implements Message<Integer> {
    COMMUNICATION(0, "Communication"), GATEWAY(1, "Gateway"), BUSINESS(2, "Business processing"), SERVICE(3, "Service"), DAO(4, "数据访问"),
    SQLMAPPER(5, "SQL mapper"), NOSQLMAPPER(6, "NOSQL Mapper"),;
    private int code;
    private String desc;

    private Layer(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
