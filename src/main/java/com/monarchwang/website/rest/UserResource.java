package com.monarchwang.website.rest;

import com.github.pagehelper.PageInfo;
import com.monarchwang.website.dao.model.User;
import com.monarchwang.website.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wanggl on 2017/6/19.
 */
@Component
@Path("/user")
public class UserResource {

	@Resource
	private UserService userService;

	@Path("/list/{page}")
	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PageInfo<User> findAll(@PathParam("page") Integer page) {
		return userService.list(page);
	}
}
