package org.fintx.service;


public interface Service<P,R> {
 public  R serve(P dto);
}
