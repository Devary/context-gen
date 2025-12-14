package org.devary.table;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.Resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @GET
    @Path("/anime")
    public Uni<TableContext> test() {
        return Uni.createFrom().item(TableContext.builder()
                .disabledActions(Set.of())
                .allowedActions(Set.of())
                .allowActions(true)
                .disabledFields(Set.of())
                .path("")
                .name("animes")
                .fields(Set.of(Field
                        .builder()
                        .name("name")
                        .type("inputText")
                        .createEditStrategy(CreateEditStrategy
                                .builder()
                                .fieldType("inputText")
                                .build())
                        .build(), Field
                        .builder()
                        .name("description")
                        .type("textEditor")
                        .createEditStrategy(CreateEditStrategy
                                .builder()
                                .fieldType("textEditor")
                                .build())
                        .build())
                ).build());
    }
}
