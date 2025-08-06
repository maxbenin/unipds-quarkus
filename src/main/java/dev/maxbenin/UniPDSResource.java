package dev.maxbenin;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UniPDSResource {

    private int i = 0;

    @GET
    public int getI() {
        return i;
    }

    @GET()
    @Path("/i2")
    public int getI2() {
        return i;
    }

    @POST
    public void addI() {
        this.i++;
    }

    @DELETE
    public void resetI() {
        this.i = 0;
    }

    @PUT
    public void setI(int i) {
        this.i = i;
    }

}
