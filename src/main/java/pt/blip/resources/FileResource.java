package pt.blip.resources;

import io.quarkus.vertx.http.runtime.devmode.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.FileUtils;
import org.jboss.resteasy.reactive.RestPath;
import pt.blip.api.AlphaFile;

import java.io.File;
import java.io.IOException;

@Path("/files")
public class FileResource {

    @GET
    @Path("{file}")
    @Produces(MediaType.APPLICATION_JSON)
    public AlphaFile read(@RestPath final String file) {
        final File readFile = new File(file);
        try {
            final String data = FileUtils.readFileToString(readFile, "UTF-8");
            return new AlphaFile(file, data);
        } catch (final IOException ioException) {
            throw new NotFoundException(
                    Response.status(Response.Status.NOT_FOUND).entity(Json.object().put(
                            "error", "File not found."
                    ).build()).build()
            );
        }
    }

    @PUT
    @Path("{file}")
    @Produces(MediaType.APPLICATION_JSON)
    public void write(@RestPath final String file, final String content) throws IOException {
        final File readFile = new File(file);
        FileUtils.writeStringToFile(readFile, content, "UTF-8");
    }
}
