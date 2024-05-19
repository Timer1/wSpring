package cn.wyh.springframework.core.io;

public interface ResourceLoader {
    String ClASS_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
