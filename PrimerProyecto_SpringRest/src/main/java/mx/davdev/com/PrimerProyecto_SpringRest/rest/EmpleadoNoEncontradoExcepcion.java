package mx.davdev.com.PrimerProyecto_SpringRest.rest;

public class EmpleadoNoEncontradoExcepcion extends RuntimeException {

	public EmpleadoNoEncontradoExcepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoNoEncontradoExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoNoEncontradoExcepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
