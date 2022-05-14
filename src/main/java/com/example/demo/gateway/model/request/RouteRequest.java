package com.example.demo.gateway.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
  
    @NonNull
    private String destinations;

    @NonNull
    private String origins;
}
