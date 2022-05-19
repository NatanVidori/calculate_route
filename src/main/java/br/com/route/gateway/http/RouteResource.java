package br.com.route.gateway.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.route.gateway.model.request.RouteRequest;
import br.com.route.gateway.model.response.DistanceResponse;
import br.com.route.service.CalculateDistanceService;

@RestController
@RequestMapping("/distance")
public class RouteResource {

    @Autowired
    private CalculateDistanceService calculateDistanceService;

    @GetMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DistanceResponse> calculate(@RequestBody RouteRequest routeRequest) {
        DistanceResponse distance = calculateDistanceService.execute(routeRequest);
        if (distance == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(distance);
        }
    }

}
