package org.fintx.service;

import org.fintx.message.Message;


public enum JournalStatus implements Message<Integer> {
	WAITING(0,"Waiting for processing"),PROCESSING(1,"Processing"),SUCCESS(2,"Success"),FAIL(3,"Fail"),CANCEL(4,"Cancel"),OPERATION(5,"Need manual operation");

    private Integer code;
    private String desc;

    private JournalStatus(Integer code, String desc) {
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
