
package org.fintx.service;


public interface Cancelable<T,R> {
public  R cancel(T t);
}
