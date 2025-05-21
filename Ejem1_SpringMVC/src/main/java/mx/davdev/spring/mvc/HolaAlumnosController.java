package mx.davdev.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class HolaAlumnosController {
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {  // Propòrciona el formulario
		return "HolaAlumnosFormulario";	
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {  // Procesa el formulario
		return "HolaAlumnosSpring";	
	}
	
	@RequestMapping("/procesarFormulario2")
	//public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		
		//String nombre = request.getParameter("nombreAlumno");
		nombre += " es el mejor Alumno";
		String mensajeFinal = "¿Quien es el mejor Alumno?" + nombre;
		
		// agregando informacion al modelo 
		modelo.addAttribute("mensaje", mensajeFinal);
		
		return "HolaAlumnosSpring";	
		
	}

}
