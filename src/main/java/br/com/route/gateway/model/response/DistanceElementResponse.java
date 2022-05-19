package br.com.route.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistanceElementResponse {

    private DistanceDistanceResponse distance;

    private DistanceDurationResponse duration;

}
