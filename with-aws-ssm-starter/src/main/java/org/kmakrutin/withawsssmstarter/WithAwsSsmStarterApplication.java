package org.kmakrutin.withawsssmstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WithAwsSsmStarterApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithAwsSsmStarterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WithAwsSsmStarterApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(@Value("${my.parameter:}") String parameter) {
        return args -> LOGGER.info("my.parameter: {}", parameter);
    }

}
