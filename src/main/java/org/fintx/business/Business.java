package org.fintx.business;

public interface Business<P,R> {    
   public BusinessDTO<R> process(BusinessDTO<P> bizVo);
}
