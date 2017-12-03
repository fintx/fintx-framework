package org.fintx.dao;

import java.util.Iterator;
import java.util.List;

//TODO  Remove retrive remove modify retriveAll those methods may cause security and performance problem
//In Dao only use add 
public interface BaseDao<T> {

    public boolean save(T record);

    public default T get(T record) {
        return null;
    };

    public default int remove(T record) {
        return 0;
    };

    public default int modify(T record) {
        return 0;
    };

    public default List<T> listAll(T record) {
        return null;
    };

    public default int saveAll(List<T> records) {
        return 0;
    };

    public default Iterator<T> iteratorAll(T record) {
        return null;
    };

}
