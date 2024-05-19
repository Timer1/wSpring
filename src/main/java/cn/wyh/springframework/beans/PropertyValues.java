package cn.wyh.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加propertyValue
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv){
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name获取propertyValue
     * @param name
     * @return
     */
    public PropertyValue getPropertyValue(String name){
        for (PropertyValue pv : propertyValueList){
            if (pv.getName().equals(name)){
                return pv;
            }
        }
        return null;
    }

}
