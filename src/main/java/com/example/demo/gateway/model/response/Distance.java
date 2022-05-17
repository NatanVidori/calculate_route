package com.example.demo.gateway.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distance {

    private List<String> destinationAddresses;

    private List<String> originAddresses;
    
    private List<DistanceRows> rows;

    private Double totalDistance;
}
