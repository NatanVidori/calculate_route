package br.com.route.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.route.exceptions.ApiGoogleErrorException;
import br.com.route.gateway.feign.GoogleApi;
import br.com.route.gateway.model.factory.DistanceFactory;
import br.com.route.gateway.model.request.RouteRequest;
import br.com.route.gateway.model.response.DistanceResponse;
import br.com.route.gateway.model.response.DistanceRowsResponse;
import br.com.route.gateway.model.response.GetDistanceApiResponse;

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