package org.fintx.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

import org.fintx.lang.FintxError;
import org.fintx.lang.FintxException;
import org.fintx.util.UniqueId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 日志工具
 *
 */
public class LogUtil {
	
	
	/**
	 * @Title: logMessage
	 * @Description 消息日志(包括错误日志)，使用slfj的Logger，�?�不是log4j的Logger�?
	 * @param T  方法调用者的Class类型
	 * @param param
	 */
    public static void logMessage(Class T, LogMessage param) {
        Logger logger = LoggerFactory.getLogger(T);
        String msg = formatArgs(param);
        logger.info(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + msg);
    }  
    
    
    /**
     * @Title: logInterface
     * @Description 接口调用日志，使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param param  参数实体
     */
    public static void logInterface(Class T, InterfaceArgs param) {
    	Logger logger = LoggerFactory.getLogger(T);
        String msg = param.toString();
        // Level lev = getLevel(param.getMsgCode());
        logger.info(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + msg);
    }   
    
    
    /**
     * 输出throwable标准方法
     * @Description 输出throwable标准方法，使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T   方法调用者的Class类型
     * @param args
     * @param thrown
     */
    public static void logError(Class T, LogMessage args, Throwable thrown) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        //FIXME
        //log.log(Level.SEVERE, args.getCode() + ":" + stackFlag + args.getDesc());
        log.error(args.getDesc().replace(":", ":" + stackFlag ));

        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        StackTraceElement[] stackArray = thrown.getStackTrace();
        log.info(time + stackFlag + thrown.getClass().getName());
        log.info(time + stackFlag + thrown.getMessage());
        for (StackTraceElement temp : stackArray) {
            log.info(time + stackFlag + temp.toString());
        }
        Throwable cause = thrown.getCause();
        if (cause != null) {
            log.info(time + stackFlag + cause.getClass().getName());
            log.info(time + stackFlag + cause.getMessage());
            stackArray = cause.getStackTrace();
            for (StackTraceElement temp : stackArray) {
                log.info(time + stackFlag + temp.toString());
            }
        }
    }     
    
    
    /**
     * 输出CoreException标准方法
     * @Description 输出CoreException标准方法。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param thrown
     * @param map
     * @param obj
     */
    public static void logError(Class T, FintxException thrown, Map<String, String> map, Object obj) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        //FIXME
        //log.log(Level.SEVERE, args.getCode() + ":" + stackFlag + args.getDesc());
        log.error(thrown.getCode() + ":" + stackFlag + thrown.getDesc());

        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        StackTraceElement[] stackArray = thrown.getStackTrace();
        log.info(time + stackFlag + thrown.getClass().getName());
        log.info(time + stackFlag + thrown.getMessage());
        for (StackTraceElement temp : stackArray) {
            log.info(time + stackFlag + temp.toString());
        }
        Throwable cause = thrown.getCause();
        if (cause != null) {
        	log.info(time + stackFlag + cause.getClass().getName());
            log.info(time + stackFlag + cause.getMessage());
            stackArray = cause.getStackTrace();
            for (StackTraceElement temp : stackArray) {
                log.info(time + stackFlag + temp.toString());
            }
        }
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            StringBuilder sb = new StringBuilder("{");
            for(Map.Entry<String, String> entry:entrySet) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
            }
            sb.append("]");
            log.info(time + stackFlag + sb.toString());
        }
        if (obj != null) {
            log.info(time + stackFlag + JSON.toJSONString(obj));
        }
    }      
    
    
    /**
     * 输出CoreError标准方法�?
     * @Description 输出CoreError标准方法。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param thrown
     * @param map
     * @param obj
     */   
    public static void logError(Class T, FintxError thrown, Map<String, String> map, Object obj) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        log.error(thrown.getCode() + ":" + stackFlag + thrown.getDesc());

        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        StackTraceElement[] stackArray = thrown.getStackTrace();
        log.info(time + stackFlag + thrown.getClass().getName());
        log.info(time + stackFlag + thrown.getMessage());
        for (StackTraceElement temp : stackArray) {
            log.info(time + stackFlag + temp.toString());
        }
        Throwable cause = thrown.getCause();
        if (cause != null) {
            log.info(time + stackFlag + cause.getClass().getName());
            log.info(time + stackFlag + cause.getMessage());
            stackArray = cause.getStackTrace();
            for (StackTraceElement temp : stackArray) {
                log.info(time + stackFlag + temp.toString());
            }
        }
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            StringBuilder sb = new StringBuilder("{");
            for(Map.Entry<String, String> entry:entrySet) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
            }
            sb.append("]");
            log.info(time + stackFlag + sb.toString());
        }
        if (obj != null) {
            log.info(time + stackFlag + JSON.toJSONString(obj));
        }
    }    
    
    
    // 
    /**
     * 输出MessageArgs标准方法
     * @Description 输出MessageArgs标准方法。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param args
     */
    public static void logError(Class T, LogMessage args) {
        Logger log = LoggerFactory.getLogger(T);
        String stackFlag = UniqueId.get().toBase64String() + " ";
        log.error(args.getCode() + ":" + stackFlag + args.getDesc());
    }
    
    
    public static void logError(Class T, String args) {
        Logger log = LoggerFactory.getLogger(T);
        log.error(args);
    }    
    
    
    
    private static String formatArgs(LogMessage param) {
        return JSON.toJSONString(param);
    }
    
    
    /**
     * @Title: logMessage
     * @Description 消息日志(包括错误日志)
     * @param param
     * 
     */
//    public static void logMessage(MessageArgs param) {
//        Logger log = LoggerFactory.getLogger("message");
//        String msg = formatArgs(param);
//        log.log(Level.INFO,DateUtil.getCurDateTime("yyyy-MM-dd HH:mm:ss:SSS ") + msg);
//    }    


    /**
     * @Title: logInterface
     * @Description 接口调用日志
     * @param param 参数实体
     * 
     */
//    public static void logInterface(InterfaceArgs param) {
//        Logger log = LoggerFactory.getLogger("interface");
//        String msg = param.toString();
//        // Level lev = getLevel(param.getMsgCode());
//        log.log(Level.INFO,DateUtil.getCurDateTime("yyyy-MM-dd HH:mm:ss:SSS ") + msg);
//    }

    
    /**
     * @Title: logError
     * @Description 输出自定义消息和thrown消息
     * @param T  方法调用者的Class类型
     * @param message
     * @param thrown
     * 
     */
    // 使用slfj的Logger，�?�不是log4j的Logger�?
    public static void logError(Class T, FintxException thrown, Map<String, String> map) {
        logError(T, thrown, map, null);
    }
    
    // 使用slfj的Logger，�?�不是log4j的Logger�?
    public static void logError(Class T, LogMessage msg, Map<String, String> map) {
        logError(T, msg, map, null);
    }
    
    
    // 使用slfj的Logger，�?�不是log4j的Logger�?
    public static void logError(Class T, LogMessage msg, Map<String, String> map,Object obj) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        
        log.error(msg.getCode() + ":" + stackFlag + msg.getDesc());

        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            StringBuilder sb = new StringBuilder("{");
            for(Map.Entry<String, String> entry:entrySet) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
            }
            sb.append("]");
            log.info(time + stackFlag + sb.toString());
        }
        if (obj != null) {
            log.info(time + stackFlag + JSON.toJSONString(obj));
        }
    }       
    
    

    /**
     * @Title: logError
     * @Description 输出自定义消息和thrown消息。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param message
     * @param thrown
     * 
     */
    public static void logError(Class T, FintxException thrown, Object obj) {
        logError(T, thrown, null, obj);
    }
    
    
    /**
     * 输出Warn级别日志
     * @Description 输出warn级别日志。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param message
     */
    public static void logWarn(Class T, String message) {
        Logger log = LoggerFactory.getLogger(T);
        log.warn(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + message);
    }  
    
    
    /**
     * 输出info级别日志
     * @Description 输出info级别日志。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param T  方法调用者的Class类型
     * @param message
     */
    public static void logInfo(Class T, String message) {
    	Logger logger = LoggerFactory.getLogger(T);
//    	logger.info(DateUtil.getCurDateTime("yyyy-MM-dd HH:mm:ss:SSS ") + message);
    	logger.info(message);
    }  
    
    
    /**
     * 输出info级别日志
     * @param T  方法调用者的Class类型。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param requestFlowID
     * @param message
     */
	public static void logInfo(Class T, String requestFlowID, String message) {
		Logger log = LoggerFactory.getLogger(T);
//		log.info(DateUtil.getCurDateTime("yyyy-MM-dd HH:mm:ss:SSS ") + "[" + requestFlowID + "]:" + message);
		log.info("[" + requestFlowID + "]:" + message);
	}    
	
	
	/**
	 * 输出info级别日志
	 * @param T  方法调用者的Class类型。使用slfj的Logger，�?�不是log4j的Logger�?
	 * @param message
	 * @param map
	 * @param obj
	 */
    public static void logInfo(Class T, String message, Map<String, String> map, Object obj) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        log.info(time + stackFlag + message);
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            StringBuilder sb = new StringBuilder("{");
            for(Map.Entry<String, String> entry:entrySet) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
            }
            sb.append("]");
            log.info(time + stackFlag + sb.toString());
        }
        if (obj != null) {
            log.info(time + stackFlag + JSON.toJSONString(obj));
        }
    }	
    
    
    /**
     * 输出info级别日志
     * @param T   方法调用者的Class类型。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param message
     * @param thrown
     */
    public static void logInfo(Class T, String message, Throwable thrown) {
        String stackFlag = UniqueId.get().toBase64String() + " ";
        Logger log = LoggerFactory.getLogger(T);
        
        String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        log.info(time + stackFlag + message);

        StackTraceElement[] stackArray = thrown.getStackTrace();
        log.info(time + stackFlag + thrown.getClass().getName());
        log.info(time + stackFlag + thrown.getMessage());
        for (StackTraceElement temp : stackArray) {
            log.info(time + stackFlag + temp.toString());
        }
        Throwable cause = thrown.getCause();
        if (cause != null) {
            log.info(time + stackFlag + cause.getClass().getName());
            log.info(time + stackFlag + cause.getMessage());
            stackArray = cause.getStackTrace();
            for (StackTraceElement temp : stackArray) {
                log.info(time + stackFlag + temp.toString());
            }
        }
    }    
    
    
    /**
     * 输出debug级别日志
     * @param T  方法调用者的Class类型。使用slfj的Logger，�?�不是log4j的Logger�?
     * @param message
     */
    public static void logdebug(Class T, String message) {
        Logger log = LoggerFactory.getLogger(T);
        log.debug(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + message);
    }    

}
