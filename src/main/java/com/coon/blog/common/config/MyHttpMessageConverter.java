package com.coon.blog.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

/**
 *  配置JsonHttpMessageConverter转换器
 */
@Configuration
public class MyHttpMessageConverter {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //定义一个fastJson的converter转换消息对象
        FastJsonHttpMessageConverter httpMessageConverter = new FastJsonHttpMessageConverter();
        //添加fastJson的配置信息
        FastJsonConfig config = new FastJsonConfig();
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //输入key时包含双引号
                SerializerFeature.QuoteFieldNames,
                //是否输出null的字段，若为null,则显示改字段
                SerializerFeature.WriteMapNullValue,
                //数值字段如果未null,则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //List字段如果为null,输出为[], 而非null
                SerializerFeature.WriteNullListAsEmpty,
                //字符串类型字段如果未null,输出未‘’ ‘’， 而非null,
                SerializerFeature.WriteNullStringAsEmpty,
                //Boolean类型字段如果未null, 输出未false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                // Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                // 循环引用
                SerializerFeature.DisableCircularReferenceDetect
        };
        config.setSerializerFeatures(serializerFeatures);
        config.setCharset(Charset.forName("UTF-8"));
        //在convert中添加配置信息
        httpMessageConverter.setFastJsonConfig(config);
        //将convert添加到converter中
        HttpMessageConverter converter = httpMessageConverter;
        return new HttpMessageConverters(converter);
    }
}
