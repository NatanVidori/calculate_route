package com.example.demo.service;

import com.example.demo.exceptions.ApiGoogleErrorException;
import com.example.demo.gateway.feign.GoogleApi;
import com.example.demo.gateway.model.request.RouteRequest;
import com.example.demo.gateway.model.response.GetDistanceApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateDistanceService {

    @Autowired
    private GoogleApi googleApi;
    
    public GetDistanceApi execute(RouteRequest routeRequest) {
        try {
            GetDistanceApi getDistanceApi = googleApi.getDistance(routeRequest);

            return getDistanceApi;
        } catch (Exception e) {
            throw new ApiGoogleErrorException();
        }
    }

}