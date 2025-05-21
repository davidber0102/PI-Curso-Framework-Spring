package com.mx.davdev.jackson.pruebas;

public class Datos_Empleado {	

	public Datos_Empleado() {		super();	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	private String domicilio,ciudad,codigo_postal, pais, fecha_alta;
}
/* 
	"datos_registro":{
		"domicilio":"Gran via 125 3ª B",
		"ciudad": "Madrid", 
		"codigo_postal": "28005",
		"pais": "España",
		"fecha_alta":"25/07/201"		
	}


*/