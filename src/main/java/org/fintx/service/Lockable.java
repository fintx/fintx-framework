package org.fintx.service;

public interface Lockable<T> {
    public boolean lock(T data);
    public boolean release(T data);
}
