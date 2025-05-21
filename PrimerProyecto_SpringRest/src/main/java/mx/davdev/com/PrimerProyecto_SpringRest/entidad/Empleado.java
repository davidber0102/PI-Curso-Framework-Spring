package mx.davdev.com.PrimerProyecto_SpringRest.entidad;

//@JsonAutoDetect(getterVisibility=Visibility.NONE)
public class Empleado {
	
	public Empleado() {
		super();
	}
	
	public Empleado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	private String nombre;
	private String apellido;

}
