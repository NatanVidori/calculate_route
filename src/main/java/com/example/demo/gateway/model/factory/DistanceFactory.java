package com.example.demo.gateway.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.gateway.model.response.Distance;
import com.example.demo.gateway.model.response.DistanceDistance;
import com.example.demo.gateway.model.response.DistanceDuration;
import com.example.demo.gateway.model.response.DistanceElement;
import com.example.demo.gateway.model.response.DistanceRows;
import com.example.demo.gateway.model.response.GetDistanceApi;

public class DistanceFactory {

    private DistanceFactory() {
    }

    public static Distance buildDistance(GetDistanceApi getDistanceApi) {
        List<DistanceRows> rowsList;
        rowsList = new ArrayList<DistanceRows>();

        getDistanceApi.getRows().forEach(distance -> {
            DistanceRows tempDistanceRows;
            List<DistanceElement> tempDistanceElementList;
            
            tempDistanceRows = new DistanceRows();
            tempDistanceElementList = new ArrayList<DistanceElement>();

            distance.getElements().forEach(elements -> {
                DistanceElement tempDistanceElement;
                DistanceDistance tempDistanceDistance;
                DistanceDuration tempDistanceDuration; 

                tempDistanceElement = new DistanceElement();
                tempDistanceDistance = new DistanceDistance();
                tempDistanceDuration = new DistanceDuration();

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

        return Distance.builder()
                .destinationAddresses(getDistanceApi.getDestination_addresses())
                .originAddresses(getDistanceApi.getOrigin_addresses())
                .rows(rowsList)
                .build();
    }

}
