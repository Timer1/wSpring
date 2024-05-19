package cn.wyh.springframework.beans;

import lombok.Data;

/**
 * 属性值
 */
@Data
public class PropertyValue {

    private final String name;

    private final Object value;
}
