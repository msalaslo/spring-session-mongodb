package com.github.msalaslo.httpsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.mongo.JacksonMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 15)
public class HttpSessionConfig {
	
	private static final String SESSION_HEADER_NAME = "x-session-id";

//    @Bean
//    public JdkMongoSessionConverter jdkMongoSessionConverter() {
//        return new JdkMongoSessionConverter(Duration.ofSeconds(15));
//    }
    
    @Bean
    JacksonMongoSessionConverter mongoSessionConverter() {
        return new JacksonMongoSessionConverter();
    }
    
	@Bean
	public HttpSessionIdResolver httpSessionIdResolver() {
		return new HeaderHttpSessionIdResolver(SESSION_HEADER_NAME); 
	}
}
