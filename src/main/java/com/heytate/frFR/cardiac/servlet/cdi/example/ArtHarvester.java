package com.heytate.frFR.cardiac.servlet.cdi.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface ArtHarvester {

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    String get();
}