package com.finartz.ticket.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by promegalex on 11.03.2020 17:27
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {
        "com.finartz.ticket"
})
@EnableMongoRepositories({
        "com.finartz.ticket.repository"
})
public class TicketApplicationConfig {
}
