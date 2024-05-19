package cn.wyh.springframework.util;

/**
 * 获取ClassPathResource类型配置文件的工具类
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){

        }
        if (cl == null){
            cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }
}
