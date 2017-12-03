package org.fintx.business;



public interface Serializer<E,R> {

   
    public R serialize(E object);
    
    public E deserialize(R content, Class<E> clazz);

}