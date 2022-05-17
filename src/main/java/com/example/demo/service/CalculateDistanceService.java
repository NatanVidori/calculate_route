package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.ApiGoogleErrorException;
import com.example.demo.gateway.feign.GoogleApi;
import com.example.demo.gateway.model.factory.DistanceFactory;
import com.example.demo.gateway.model.request.RouteRequest;
import com.example.demo.gateway.model.response.Distance;
import com.example.demo.gateway.model.response.DistanceRows;
import com.example.demo.gateway.model.response.GetDistanceApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateDistanceService {

    @Autowired
    private GoogleApi googleApi;

    private Double totalDistance;

    private Double totalDistanceRow;

    public Distance execute(RouteRequest routeRequest) {
        try {
            GetDistanceApi getDistanceApi = googleApi.getDistance(routeRequest);

            Distance distance = DistanceFactory.buildDistance(getDistanceApi);

            distance.setTotalDistance(sumDistance(distance.getRows()));

            return distance;
        } catch (Exception e) {
            throw new ApiGoogleErrorException();
        }
    }

    private Double sumDistance(List<DistanceRows> rowsList) {
        totalDistance = 0.00;

        rowsList.forEach(row -> {
            totalDistanceRow = 0.00;

            row.getElements().forEach(elements -> {
                totalDistance = totalDistance + elements.getDistance().getValue();
                totalDistanceRow = totalDistanceRow + elements.getDistance().getValue();
            });

            row.setTotalDistanceRow(totalDistanceRow / 1000);
        });

        return totalDistance / 1000;
    }
}