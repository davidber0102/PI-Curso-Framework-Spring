package mx.davdev.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {	
	@InitBinder
	public void miBinder(WebDataBinder binder) {
		StringTrimmerEditor recorte = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, recorte);
	}
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model modelo) {		
		Alumno al = new Alumno();				// se instancia y crea un objeto aAlumno pat guardar lo del formulario
		modelo.addAttribute("Alumno", al);		// se agrega el model para poder ser utilizado como puente o vehiculo trasmisor entre los controllers
		return "alumnoRegistroFormulario";		// retorna una pagina jsp para registrar  alumnos
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@Valid @ModelAttribute("Alumno") Alumno a1, BindingResult resultadoValidacion ) {					
		if(resultadoValidacion.hasErrors()) {
			return "alumnoRegistroFormulario";	
		}else {
			return "confirmacionRegistroAlumno";
		}
	}
}
