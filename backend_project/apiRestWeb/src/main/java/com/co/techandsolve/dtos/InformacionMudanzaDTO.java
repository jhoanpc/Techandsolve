package com.co.techandsolve.dtos;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;
public class InformacionMudanzaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FormParam("tipoIdentificacion")
	private String tipoIdentificacion;
	@FormParam("numeroIdentificacion")
	private String numeroIdentificacion;
	private byte[] data;
	


	public InformacionMudanzaDTO(){
		
	}
	
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public byte[] getData() {
		return data;
	}
	@FormParam("uploadedFile")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
	
}
