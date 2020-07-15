package com.jc.message.converter;

import org.springframework.context.annotation.Configuration;

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
public class MessageConverterConfig {
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
