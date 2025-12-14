package org.devary.table;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.devary.table.utils.ContextLoader;

import java.io.InputStream;
import java.util.Set;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @Inject
    ContextLoader loader;

    @GET
    @Path("/sharacter")
    public Uni<TableContext> test() {
        InputStream input = getClass().getResourceAsStream("sharacter.txt");
        return Uni.createFrom().item(this.loader.load(input));
    }
}
