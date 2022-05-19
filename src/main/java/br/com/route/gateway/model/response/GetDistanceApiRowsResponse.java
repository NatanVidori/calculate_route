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
public class GetDistanceApiRowsResponse {
    
    private List<GetDistanceApiElementResponse> elements;
    
}
