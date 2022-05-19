package br.com.route.gateway.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistanceResponse {

    private List<String> destinationAddresses;

    private List<String> originAddresses;
    
    private List<DistanceRowsResponse> rows;

    private Double totalDistance;
}
