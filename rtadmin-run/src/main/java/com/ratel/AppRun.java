package com.ratel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ratel.framework.utils.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.TimeZone;

@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ratel.modules.*.mapper")
@Configuration
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }


    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public ServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
        fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
        return fa;
    }

//    @Bean
//    @Primary
//    @ConditionalOnMissingBean(ObjectMapper.class)
//    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//
//        // 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
//        // Include.Include.ALWAYS 默认
//        // Include.NON_DEFAULT 属性为默认值不序列化
//        // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
//        // Include.NON_NULL 属性为NULL 不序列化
//        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));//解决时区差8小时问题
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        // 允许出现特殊字符和转义符
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        // 允许出现单引号
//        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        // 字段保留，将null值转为""
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
//                    throws IOException {
//                jsonGenerator.writeString("");
//            }
//        });
//        return objectMapper;
//    }

    /**
     * 访问首页提示
     * @return /
     */
//    @GetMapping("/")
//    @AnonymousAccess
//    public String index() {
//        return "Backend service started successfully";
//    }
}
