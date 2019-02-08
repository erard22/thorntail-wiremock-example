package ch.erard22.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Path("/hello")
public class HelloEndpoint {


	@GET
	@Produces("text/plain")
	@Path("/{echo}")
	public Response doGet(@PathParam("echo") String echo) {
		Response response = createRestEasyClient().doGet(echo);
		return Response.ok(response.getEntity()).build();
	}


	public EchoRestClient createRestEasyClient() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath("http://localhost:" + System.getProperty("echo.port", "8081")));
		return target.proxy(EchoRestClient.class);
	}

	/*
	public EchoRestClient createMicroProfileClient() throws MalformedURLException {
		return RestClientBuilder.newBuilder()
				.baseUrl(new URL("http://localhost:8080/uuid"))
				.build(EchoRestClient.class);
	}
	*/
}
