package cn.wyh.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"location不为空");
        if (location.startsWith(ClASS_URL_PREFIX)){
            return new ClassPathResource(location.substring(ClASS_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
