package mx.davdev.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorEjercicio1 {

	@RequestMapping(value = "/")
	public String muestraPagina() {
	
		return "paginaEjemplo";
	}

}
