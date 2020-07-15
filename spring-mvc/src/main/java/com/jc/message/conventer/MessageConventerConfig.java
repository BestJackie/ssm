package com.jc.message.conventer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * FileName: MessageConventerConfig
 *
 * @author: haichaoyang3
 * @date: 2020/7/14 16:51
 * Description:
 * History:
 * since: 1.0.0
 */

@Configuration
public class MessageConventerConfig {
    /*@Bean*//*("requestMappingHandlerAdapter")*//*
    public HandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

//        MediaType mediaType = MediaType.APPLICATION_JSON;

        List<MediaType> mediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        requestMappingHandlerAdapter.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        return requestMappingHandlerAdapter;

    }*/


    /*private List<Converter> converters = null;
    @Autowired(required = false)
    private FormattingConversionServiceFactoryBean formattingConversionServiceFactoryBean =null;

    @Bean
    public List<Converter> myConverter(){
        if (Objects.isNull(converters)){
            converters = new ArrayList<>();
        }
        Converter roleConverter = new String2RoleConventer();
        converters.add(roleConverter);
        formattingConversionServiceFactoryBean.getObject().addConverter(roleConverter);
        return converters;
    }*/





}
