package br.com.jproject.feedbackcampus.core.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDbConfig {
    @Value("${mongo.connection}")
    private String stringMongoConnection;

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoConfigure());
    }
    @Bean
    protected MongoDatabaseFactory mongoConfigure() {
        return new SimpleMongoClientDatabaseFactory(stringMongoConnection);
    }
}
