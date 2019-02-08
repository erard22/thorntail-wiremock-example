package ch.erard22.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/echo")
public interface EchoRestClient {

    @GET
    @Produces("text/plain")
    @Path("/{echo}")
    Response doGet(@PathParam("echo") String echo);
}
