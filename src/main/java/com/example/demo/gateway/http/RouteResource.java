package com.example.demo.gateway.http;

import com.example.demo.gateway.model.request.RouteRequest;
import com.example.demo.gateway.model.response.GetDistanceApi;
import com.example.demo.service.CalculateDistanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class RouteResource {

    @Autowired
    private CalculateDistanceService calculateDistanceService;

    @GetMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetDistanceApi> calculate(@RequestBody RouteRequest routeRequest) {
        GetDistanceApi getDistanceApi = calculateDistanceService.execute(routeRequest);
        if (getDistanceApi == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(getDistanceApi);
        }
    }

}
