package dev.maxbenin;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {
        if(starWarsService.getStarShips().contains(StarWarsService.MSG_ERRO)) {
            return HealthCheckResponse.down("Readiness Check");
        } else {
            return HealthCheckResponse.up("Readiness Check");
        }
    }
}
