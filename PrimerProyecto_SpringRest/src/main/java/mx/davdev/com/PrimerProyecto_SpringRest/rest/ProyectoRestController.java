package mx.davdev.com.PrimerProyecto_SpringRest.rest;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba")
public class ProyectoRestController {
	
	@GetMapping("/saludo")
	public String saludoPrueba() {
		return "Funciona!! y estamos vivos";
	}

}
