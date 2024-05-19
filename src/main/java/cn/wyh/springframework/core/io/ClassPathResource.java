package cn.wyh.springframework.core.io;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.util.ClassUtils;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Data
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path){
        this(path,null);
    }

    public ClassPathResource(String path, ClassLoader classLoader){
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if(is == null){
            throw new FileNotFoundException(this.path + "无法加载因为该类不存在");
        }
        return is;
    }
}
