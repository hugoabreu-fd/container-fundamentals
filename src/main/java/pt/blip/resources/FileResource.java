package pt.blip.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
    public AlphaFile read(@RestPath final String file) throws IOException {
        final File readFile = new File(file);
        String data = FileUtils.readFileToString(readFile, "UTF-8");
        return new AlphaFile(file, data);
    }
}
