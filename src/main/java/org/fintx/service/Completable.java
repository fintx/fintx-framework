
package org.fintx.service;



public interface Completable<P,R> {
    public R complete(P dto);
    //public boolean changeStatus(String bizSn,String status);
    //public <E> E queryDayJour(String txnDate,T jou);
}
