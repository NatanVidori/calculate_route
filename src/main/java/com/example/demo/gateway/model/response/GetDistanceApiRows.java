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
public class GetDistanceApiRows {
    
    private List<GetDistanceApiElement> elements;
    
}
