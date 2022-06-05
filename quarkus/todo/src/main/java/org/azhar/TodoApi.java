package org.azhar;


import org.azhar.database.DatabaseRepository;
import org.azhar.database.DatabaseResources;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@SecurityScheme(
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT"
)
@Path("/todo")
@ApplicationScoped
public class TodoApi {

    @Inject
    DatabaseResources databaseResources;


    @PUT
    @Path("/add")
    @RolesAllowed("ROLE_USER")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addList(DatabaseRepository databaseRepository){
        return databaseResources
                .newTodoList(databaseRepository)?
                    Response.ok().build():
                    Response.status(Response.Status.BAD_REQUEST).build();
    }


    @GET
    @Path("/list")
    @RolesAllowed("ROLE_USER")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getList(DatabaseRepository databaseRepository){
        return databaseResources
                .checkEmail(databaseRepository.email)?
                 Response.status(Response.Status.BAD_REQUEST).build():
                 Response.ok(databaseResources.getTodoList(databaseRepository.email)).build();
    }


    @PUT
    @Path("/update")
    @RolesAllowed("ROLE_USER")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStatus(DatabaseRepository databaseRepository){
        return Response.ok(
                databaseResources.changeStatus(databaseRepository.id, databaseRepository.status)
                )
                .build();
    }


    @DELETE
    @Path("/delete")
    @RolesAllowed("ROLE_USER")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteList(DatabaseRepository databaseRepository){
        return Response.ok(
                databaseResources.deleteList(databaseRepository.id)
                )
                .build();
    }

}
