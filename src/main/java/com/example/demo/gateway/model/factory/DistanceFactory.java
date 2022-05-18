package com.example.demo.gateway.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.gateway.model.response.DistanceResponse;
import com.example.demo.gateway.model.response.DistanceDistanceResponse;
import com.example.demo.gateway.model.response.DistanceDurationResponse;
import com.example.demo.gateway.model.response.DistanceElementResponse;
import com.example.demo.gateway.model.response.DistanceRowsResponse;
import com.example.demo.gateway.model.response.GetDistanceApiResponse;

public class DistanceFactory {

    private DistanceFactory() {
    }

    public static DistanceResponse buildDistance(GetDistanceApiResponse getDistanceApi) {
        List<DistanceRowsResponse> rowsList;
        rowsList = new ArrayList<DistanceRowsResponse>();

        getDistanceApi.getRows().forEach(distance -> {
            DistanceRowsResponse tempDistanceRows;
            List<DistanceElementResponse> tempDistanceElementList;
            
            tempDistanceRows = new DistanceRowsResponse();
            tempDistanceElementList = new ArrayList<DistanceElementResponse>();

            distance.getElements().forEach(elements -> {
                DistanceElementResponse tempDistanceElement;
                DistanceDistanceResponse tempDistanceDistance;
                DistanceDurationResponse tempDistanceDuration; 

                tempDistanceElement = new DistanceElementResponse();
                tempDistanceDistance = new DistanceDistanceResponse();
                tempDistanceDuration = new DistanceDurationResponse();

                tempDistanceDistance.setText(elements.getDistance().getText());
                tempDistanceDistance.setValue(Double.parseDouble(elements.getDistance().getValue()));
                
                tempDistanceDuration.setText(elements.getDuration().getText());
                tempDistanceDuration.setValue(Double.parseDouble(elements.getDuration().getValue()));

                tempDistanceElement.setDistance(tempDistanceDistance);
                tempDistanceElement.setDuration(tempDistanceDuration);

                tempDistanceElementList.add(tempDistanceElement);
            });

            tempDistanceRows.setElements(tempDistanceElementList);

            rowsList.add(tempDistanceRows);
        });

        return DistanceResponse.builder()
                .destinationAddresses(getDistanceApi.getDestination_addresses())
                .originAddresses(getDistanceApi.getOrigin_addresses())
                .rows(rowsList)
                .build();
    }

}
