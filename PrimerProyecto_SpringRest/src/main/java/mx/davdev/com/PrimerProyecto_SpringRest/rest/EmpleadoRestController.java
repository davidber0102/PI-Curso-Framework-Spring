package mx.davdev.com.PrimerProyecto_SpringRest.rest;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import mx.davdev.com.PrimerProyecto_SpringRest.entidad.Empleado;

@RestController
@RequestMapping(path= "/api", consumes = "application/json")
public class EmpleadoRestController {
	
	private List<Empleado> losEmpleados;
	
	@PostConstruct
	public void CargaDatos() {
		losEmpleados = new ArrayList<>();
		
		losEmpleados.add(new Empleado("David", "Bernal"));
		losEmpleados.add(new Empleado("Juan", "Diaz"));
		losEmpleados.add(new Empleado("Ana", "Gomez"));
		losEmpleados.add(new Empleado("Maria", "Perez"));
		losEmpleados.add(new Empleado("Antonio", "Lopez"));
		
	}

	@GetMapping(value = "/empleados", consumes = "application/json")
	public List<Empleado> getEmpleados() throws Exception{
				
		return losEmpleados;
		
	}
	
	@GetMapping("/empleados/{empleadoId}")
	public Empleado getEmpleado(@PathVariable int empleadoId) {
		
		// comprueba si existe el empleado con su ID
		
		if((empleadoId >= losEmpleados.size()) || empleadoId <0 ) {
			throw new EmpleadoNoEncontradoExcepcion("El id" + empleadoId + "no existe. el empleado no se encontro");
		}
		
		return losEmpleados.get(empleadoId);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<EmpleadoRespuestaError> manejoExcepcion(EmpleadoNoEncontradoExcepcion ex){
		
		EmpleadoRespuestaError error = new EmpleadoRespuestaError();
		error.setEstado(HttpStatus.NOT_FOUND.value());
		error.setMensaje(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND );
		
		
	}
	
	
}
