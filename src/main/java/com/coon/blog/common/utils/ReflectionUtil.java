package com.coon.blog.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class ReflectionUtil extends org.springside.modules.utils.reflect.ReflectionUtil{
    public  static Map<String,Object> getPropertyMap(Object object){
        Map<String,Object> map= Maps.newHashMap();
        List<Field> fieldList= Lists.newArrayList();
        getFields(fieldList,object.getClass());
        for(Field field:fieldList){
            field.setAccessible(true);
            map.put(field.getName(),getFieldValue(object,field));
        }
        return map;
    }

    //递归获取所有Field
    public static void getFields(List<Field> fields, Class clazz) {
        for(Field field:clazz.getDeclaredFields()) {
            fields.add(field);
        }
        clazz = clazz.getSuperclass();
        if (!clazz.getName().equals(Object.class.getName())) {
            getFields(fields,clazz);
        }
    }
}
