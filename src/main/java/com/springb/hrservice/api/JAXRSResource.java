package com.springb.hrservice.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("persons")
public class JAXRSResource {

	//@Inject
	
	@GET
	public Response index(@Context UriInfo uriInfo) {
		System.out.println("in index get");
		Response response = Response.ok().entity("HI").build();
		return response;
	}
}
