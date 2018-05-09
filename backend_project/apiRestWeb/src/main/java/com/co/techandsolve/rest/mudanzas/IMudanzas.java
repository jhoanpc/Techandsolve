package com.co.techandsolve.rest.mudanzas;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.co.techandsolve.dtos.InformacionMudanzaDTO;
@Path("/mudanzas")
public interface IMudanzas {
	
	@POST
    @Path("/guardarRegistro")
	@Consumes({ MediaType.MULTIPART_FORM_DATA ,MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
	public Response guardarRegistro( @MultipartForm InformacionMudanzaDTO input);
	
	

}
