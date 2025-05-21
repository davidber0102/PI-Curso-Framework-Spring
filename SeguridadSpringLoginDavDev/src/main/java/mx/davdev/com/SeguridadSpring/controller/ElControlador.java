package mx.davdev.com.SeguridadSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElControlador {
	
	@GetMapping("/")
	public String muestraIncio() {
		return "inicio";
	}
	// agrrgar mapping a adminstradores
	@GetMapping("/administradores")
	public String muestraAdministradores() {
		return "administradores";
	}
	
	// agrrgar mapping para la pagina de acceso denegado
	@GetMapping("/acceso-denegado")
	public String muestraAcesoDenegado() {
		return "acceso-denegado";
	}
	
	// agregar mapping a ayudantes
	@GetMapping("/ayudantes")
	public String muestraAyudantes() {
		return "ayudantes";
	}

}
