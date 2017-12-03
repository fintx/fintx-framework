
package org.fintx.business.util;

import org.fintx.business.BusinessDate;
import org.fintx.business.BusinessId;

import java.lang.annotation.Repeatable;
import java.lang.reflect.Field;


public final class BusinessUtil {

    public static <T>  String getBizId(T bizObj) {
        int size = 0;
        int order = 0;
        String[] columns = new String[10];
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) bizObj.getClass();
        Field fields[] = clazz.getDeclaredFields();
        BusinessId annotation = null;
        for (Field f : fields) {
            annotation = f.getAnnotation(BusinessId.class);
            if (null != annotation) {
                Object value = null;
                f.setAccessible(true);
                try {
                    value = f.get(bizObj);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (null != value) {
                    order=annotation.order();
                    if (order > size) {
                        size = annotation.order();
                    }
                    columns[order]=value.toString();
                } else {
                    throw new RuntimeException("@BusinessId注解的字段不能为空！");
                }
            }
        }
        
        StringBuilder bizIds = new StringBuilder();
        if (null != columns[0]) {
            bizIds.append(columns[0]);
        }
        for (int i = 1; i <= size; i++) {
            if(null!=columns[i]){
                bizIds.append("-"+columns[i]); 
            }else{
                throw new RuntimeException("@BusinessId注解order值必须连续"); 
            }
        }
        if(bizIds.length()==0){
            Field field = null;
            Object value = null;
            try{
                field=clazz.getDeclaredField("bizId");
            }catch(NoSuchFieldException |SecurityException e){
            }
            if(null!=field){
                field.setAccessible(true);
                try {
                    value = field.get(bizObj);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if(null!=value){
                return value.toString();
            }else{
                throw new RuntimeException("获取BizId失败：Class："+bizObj.getClass());
            } 
        }else{
            return bizIds.toString();
        }
    }
    
    public static <T> String getBizDate(T bizObj) {
        Object value = null;
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) bizObj.getClass();
        Field fields[] = clazz.getDeclaredFields();
        BusinessDate annotation = null;
        for (Field f : fields) {
            f.setAccessible(true);
            annotation = f.getAnnotation(BusinessDate.class);
            if (null != annotation) {
                
                try {
                    value = f.get(bizObj);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (null == value) 
                    throw new RuntimeException("@BusinessDate注解的字段不能为空！");
                }
            }
        if(null==value){
            Field field = null;
            try{
                field=clazz.getDeclaredField("bizDate");
            }catch(NoSuchFieldException |SecurityException e){
            }
            if(null!=field){
                field.setAccessible(true);
                try {
                    value = field.get(bizObj);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if(null!=value){
                return value.toString();
            }else{
                throw new RuntimeException("获取BizDate失败：Class："+bizObj.getClass());
            }
        }else{
            return value.toString(); 
        }
    }
    
    public static <T> boolean isRepeatable(T bizObj) {
        if(null==bizObj.getClass().getAnnotation(Repeatable.class)){
            return false;
        }else{
            return true;
        }
        
    }
    

 

}
