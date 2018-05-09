package com.co.techandsolve.rest.mudanzas;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.co.techandsolve.business.MudanzaBusiness;
import com.co.techandsolve.dtos.InformacionMudanzaDTO;


public class MudanzasRest implements IMudanzas {
	
	@Inject
	public MudanzaBusiness mudanzasBusiness;


	
	public Response guardarRegistro( InformacionMudanzaDTO input){
		  byte[] bytes = input.getData();
		 
		 
		mudanzasBusiness = new MudanzaBusiness();
		String resultado = mudanzasBusiness.realizarMudanza(bytes, input.getNumeroIdentificacion());
		
		 //return Response.ok(json, MediaType.APPLICATION_JSON).build();	
		return Response.ok(resultado).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	
	

}
