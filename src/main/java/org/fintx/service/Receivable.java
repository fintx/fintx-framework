package org.fintx.service;

public interface Receivable<P,R> {
    public R receive(P result);
}
