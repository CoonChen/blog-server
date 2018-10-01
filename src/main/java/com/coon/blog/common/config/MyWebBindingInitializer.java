package com.coon.blog.common.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *  controller 层增强器
 *  request请求参数解析转换
 */
@ControllerAdvice
public class MyWebBindingInitializer {
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        /* LocalDateTime 类型转换 */
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                LocalDateTime localDateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                setValue(localDateTime);
            }
        });


        /* LocalDate 类型转换 */
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                setValue(localDate);
            }
        });

        /* LocalTime 类型转换 */
        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                LocalTime localTime = LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm:ss"));
                setValue(localTime);
            }
        });
    }
}
