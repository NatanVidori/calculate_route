package com.example.demo.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class GoogleApiFeignClientInterceptor implements RequestInterceptor {

    @Value("${api.google.header.host}")
    private String headerHost;

    @Value("${api.google.header.host.value}")
    private String headerHostValue;

    @Value("${api.google.header.key}")
    private String headerKey;

    @Value("${api.google.key}")
    private String headerKeyValue;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(headerHost, headerHostValue);
        requestTemplate.header(headerKey, headerKeyValue);
    }

}
