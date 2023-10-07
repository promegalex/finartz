package com.finartz.ticket.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Created by promegalex on 12.03.2020 17:27
 */
@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {

        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().build();

        return new MongoClient(new ServerAddress("127.0.0.1", 27017), mongoClientOptions);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = mongoClient();
        return new MongoTemplate(mongoClient, "database");
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoClient mongoClient = mongoClient();
        return new SimpleMongoDbFactory(mongoClient, "database");
    }

    @Bean
    public MappingMongoConverter mongoConverter() {
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        return new MappingMongoConverter(dbRefResolver, mappingContext);
    }


}
