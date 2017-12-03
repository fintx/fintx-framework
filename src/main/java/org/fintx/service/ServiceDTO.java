package org.fintx.service;

import org.fintx.business.BusinessDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceDTO<E> extends BusinessDTO<E> {
    /**
     * 
     */
    //TODO bizSn-txnSn
    private static final long serialVersionUID = -4388429486520183422L;
    private String txnDate;
    private String bizSn;
}
