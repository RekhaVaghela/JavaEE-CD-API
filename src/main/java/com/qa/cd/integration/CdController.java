package com.qa.cd.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.CdInterfaceRepository;


@Path("/cd")
public class CdController {
	@Inject
	private CdInterfaceRepository service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCd() {
		return service.getAllCd();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCd(String account) {
		return service.addCd(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCd(@PathParam("id") Long id, String account) {
		return service.updateCd(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCd(@PathParam("id") Long id) {
		return service.deleteCd(id);
	}

	public void setService(CdInterfaceRepository service) {
		this.service = service;
	}


}
