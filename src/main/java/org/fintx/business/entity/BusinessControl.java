package org.fintx.business.entity;

import org.fintx.business.BusinessId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessControl {
    /**
     * <pre>
     * 
     * 表字段 : t_business_control.id
     * </pre>
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * <pre>
     * 
     * 表字段 : t_business_control.app_id
     * </pre>
     *
     * @mbg.generated
     */
    private String appId;

    /**
     * <pre>
     * 
     * 表字段 : t_business_control.biz_code
     * </pre>
     *
     * @mbg.generated
     */
    private String bizCode;

    /**
     * <pre>
     * 
     * 表字段 : t_business_control.biz_date
     * </pre>
     *
     * @mbg.generated
     */
    private String bizDate;

    /**
     * <pre>
     * 
     * 表字段 : t_business_control.biz_id
     * </pre>
     *
     * @mbg.generated
     */
    @BusinessId(order = 0)
    private String bizId;
}