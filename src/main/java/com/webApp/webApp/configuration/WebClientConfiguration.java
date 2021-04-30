package com.webApp.webApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
	
	@Bean
    public WebClient webClientAsync() {
        return new WebClient() {
            @Override
            public RequestHeadersUriSpec<?> get() {
                return null;
            }

            @Override
            public RequestHeadersUriSpec<?> head() {
                return null;
            }

            @Override
            public RequestBodyUriSpec post() {
                return null;
            }

            @Override
            public RequestBodyUriSpec put() {
                return null;
            }

            @Override
            public RequestBodyUriSpec patch() {
                return null;
            }

            @Override
            public RequestHeadersUriSpec<?> delete() {
                return null;
            }

            @Override
            public RequestHeadersUriSpec<?> options() {
                return null;
            }

            @Override
            public RequestBodyUriSpec method(HttpMethod httpMethod) {
                return null;
            }

            @Override
            public Builder mutate() {
                return null;
            }
        };
    }
}
