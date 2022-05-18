package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.ApiGoogleErrorException;
import com.example.demo.gateway.feign.GoogleApi;
import com.example.demo.gateway.model.factory.DistanceFactory;
import com.example.demo.gateway.model.request.RouteRequest;
import com.example.demo.gateway.model.response.DistanceResponse;
import com.example.demo.gateway.model.response.DistanceRowsResponse;
import com.example.demo.gateway.model.response.GetDistanceApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateDistanceService {

    @Autowired
    private GoogleApi googleApi;

    private Double totalDistance;

    private Double totalDistanceRow;

    public DistanceResponse execute(RouteRequest routeRequest) {
        try {
            GetDistanceApiResponse getDistanceApi = googleApi.getDistance(routeRequest);

            DistanceResponse distance = DistanceFactory.buildDistance(getDistanceApi);

            distance.setTotalDistance(sumDistance(distance.getRows()));

            return distance;
        } catch (Exception e) {
            throw new ApiGoogleErrorException();
        }
    }

    private Double sumDistance(List<DistanceRowsResponse> rowsList) {
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