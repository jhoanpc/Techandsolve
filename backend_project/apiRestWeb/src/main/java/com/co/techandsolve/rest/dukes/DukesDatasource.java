package com.co.techandsolve.rest.dukes;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/dukes")
public class DukesDatasource {


	@GET
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces({ APPLICATION_JSON + ";charset=utf-8" })
	@Path("/servicioPrueba")
	public Response servicioPrueba (){
	  String json = "{"+
    "primero"+":{"+"name"+":"+"jun"+", "+"age"+":4},"+
    "segundo"+":{"+"name"+":"+"jaonan rober"+", "+"age"+":5}"+
		"}";
	 return Response.ok(json, MediaType.APPLICATION_JSON).build();	
	}
	
	
//	public JsonObject addDuke(String name, int age){
//		return JsonObject.
//	}
}
