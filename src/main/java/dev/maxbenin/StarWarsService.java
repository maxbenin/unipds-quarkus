package dev.maxbenin;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsService {


    String MSG_ERRO = "fallback: Starships not available at the moment.";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/starships")
    @Timeout(3000L)
    @Fallback(
            fallbackMethod = "getStarShipsFallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 2,
            failureRatio = 0.5f,
            delay = 3000L,
            successThreshold = 2
    )
    String getStarShips();


    default String getStarShipsFallback() {
        return MSG_ERRO;
    }
}
