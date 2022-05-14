package com.example.demo.gateway.feign;

import com.example.demo.config.feign.GoogleApiConfig;
import com.example.demo.gateway.model.request.RouteRequest;
import com.example.demo.gateway.model.response.GetDistanceApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.cloud.openfeign.SpringQueryMap;

@Service
@FeignClient(
        name = "${api.google.name}",
        url = "${api.google.url}",
        configuration = GoogleApiConfig.class
)
public interface GoogleApi {

    @GetMapping(
            value = "/json?key=${api.google.key}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    GetDistanceApi getDistance(@SpringQueryMap RouteRequest routeRequest);

}


