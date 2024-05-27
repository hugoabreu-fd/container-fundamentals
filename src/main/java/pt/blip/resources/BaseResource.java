package pt.blip.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pt.blip.api.AlphaValue;

import java.util.UUID;

@Path("/")
public class BaseResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AlphaValue alphaCompute() {
        return new AlphaValue(UUID.randomUUID().toString(), 0.01);
    }
}
