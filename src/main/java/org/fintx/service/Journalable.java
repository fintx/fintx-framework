
package org.fintx.service;



//TODO add listProcessData(txnDate,timeOut)   check(Journal) get(requestId)
public interface Journalable<P,R> {
    public R journalize(P jou);
    //public boolean changeStatus(String bizSn,String status);
    //public <E> E queryDayJour(String txnDate,T jou);
}
