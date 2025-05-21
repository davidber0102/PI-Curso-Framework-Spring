package mx.davdev.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ejem1_Controller {
	
	@RequestMapping
	public String muestraPagina() {
		return "paginaEjemplo";
	}

}
