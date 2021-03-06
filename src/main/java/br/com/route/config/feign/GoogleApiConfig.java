package br.com.route.config.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class GoogleApiConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new GoogleApiFeignClientInterceptor();
    }

}
