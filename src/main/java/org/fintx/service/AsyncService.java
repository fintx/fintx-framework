
package org.fintx.service;



//TODO 创建ServiceVo作为B
public interface AsyncService<B,E,T> extends Service<B,Void> {
 public  void serve(ServiceDTO<B> svcVo);
 //撤销应该属于一项业务 放在Business层
 //public <B> boolean cancel(B biz);
 public E query(ServiceDTO<T> svcVo);
 public void complete(String bizSn);
}
