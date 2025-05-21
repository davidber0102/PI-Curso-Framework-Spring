package mx.davdev.com.SeguridadSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLoginPropio {
	
	@GetMapping("/miFormularioLogin")
	public String MuestraLoginPropio() {
		return "login_nuevo";
		
	}
}
