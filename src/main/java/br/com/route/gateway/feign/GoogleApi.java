package br.com.route.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.route.config.feign.GoogleApiConfig;
import br.com.route.gateway.model.request.RouteRequest;
import br.com.route.gateway.model.response.GetDistanceApiResponse;

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
    GetDistanceApiResponse getDistance(@SpringQueryMap RouteRequest routeRequest);

}


