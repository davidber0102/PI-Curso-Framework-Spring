package com.mx.davdev.jackson.pruebas;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class DriverJackson {
	public static void main(String[] args) {
		
		try {
			// crear un objeto mapper
			ObjectMapper miMapper = new ObjectMapper();
			
			// leer el json y convertiro a pojo
			Empleado miEmpleado = miMapper.readValue(new File("data/datos_empleados.json"), Empleado.class);
			
			// ver informacin en consola
			System.out.println("Nombre del empleado: " + miEmpleado.getNombre());
			System.out.println("Apellido del empleado: " + miEmpleado.getApellido());
			System.out.println("Empleado Activo: " + miEmpleado.isActivo());
			
			for(String idioma: miEmpleado.getIdiomas()) {
			
				System.out.println("Idioma que domina el usuario: " + idioma);
			}

			Datos_Empleado datos_empleado = miEmpleado.getDatos_registro();
			System.out.println("Domicilio del empleado: " + datos_empleado.getDomicilio());
			System.out.println("Codigo Postal del empleado: " + datos_empleado.getCodigo_postal());
			
		}catch(Exception e){
			e.printStackTrace();		}

	}

}
