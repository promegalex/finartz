package com.finartz.ticket.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by promegalex on 11.03.2020 17:27
 */
//@EnableAutoConfiguration
@Configuration
//@ComponentScan(basePackages = {
//        "com.finartz.ticket"
//})
//@EnableMongoRepositories({
//        "com.finartz.ticket.repository"
//})
public class TicketApplicationConfig {
}
