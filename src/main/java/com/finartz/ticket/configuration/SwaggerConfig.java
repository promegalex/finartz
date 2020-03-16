package com.finartz.ticket.configuration;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by promegalex on 16.03.2020 11:08
 */
@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {

    @Value("${swagger.schemes}")
    private String schemas;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(new HashSet<>(Arrays.asList("http")))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }
}
