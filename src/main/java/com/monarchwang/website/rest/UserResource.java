package com.monarchwang.website.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wanggl on 2017/6/19.
 */
@Path("user")
public interface UserResource {

	//@ApiOperation(value = "校验")   //swagger
	@Path("/authIdentity")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String login();
}
