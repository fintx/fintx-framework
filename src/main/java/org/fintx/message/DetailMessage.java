package org.fintx.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailMessage<T> implements Message<T> {
    private T code;
    private String desc;
    private String detail;
    public DetailMessage(Message<T> msg) {
        this.code=msg.getCode();
        this.desc=msg.getDesc();
    }
    public void setMessage(Message<T> msg) {
        this.code=msg.getCode();
        this.desc=msg.getDesc();
    }

}
