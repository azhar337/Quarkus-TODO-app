package org.azhar;


import org.azhar.database.DatabaseRepository;
import org.azhar.database.DatabaseResources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/todo")
@ApplicationScoped
public class TodoApi {

    @Inject
    DatabaseResources databaseResources;

    @PUT
    @Path("/add")
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
