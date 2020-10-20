package com.springb.hrservice.api;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.framework.dbdelegate.configuration.DatabaseManager;

//http://localhost:9093/personalservice/v1/persons

@Path("persons")
public class JAXRSResource {

	@Inject
	private PersonalResourceDelegate personalResourceDelegate;
	private static final Logger logger = LoggerFactory.getLogger(JAXRSResource.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response index(@Context UriInfo uriInfo) throws Exception {
		logger.info("in index getJAXResource ");
		Response response = null;
		try {
			response = personalResourceDelegate.getPersonsList();
			return response;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
}
