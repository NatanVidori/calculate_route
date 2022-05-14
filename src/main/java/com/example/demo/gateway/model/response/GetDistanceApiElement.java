package com.example.demo.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDistanceApiElement {

    private GetDistanceApiDistance distance;

    private GetDistanceApiDuration duration;

}
