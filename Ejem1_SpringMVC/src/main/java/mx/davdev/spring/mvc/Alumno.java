package mx.davdev.spring.mvc;
import javax.validation.constraints.*;
import mx.davdev.spring.mvc.validacionesPersonalizadas.CPostalMadrid;

public class Alumno {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}	
	
	public String getOptativa() {
		return optativa;
	}
	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}

	public String getCiudadEstudios() {
		return ciudadEstudios;
	}
	public void setCiudadEstudios(String ciudadEstudios) {
		this.ciudadEstudios = ciudadEstudios;
	}
	public String getIdiomasAlumno() {
		return idiomasAlumno;
	}
	public void setIdiomasAlumno(String idiomasAlumno) {
		this.idiomasAlumno = idiomasAlumno;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@NotNull
	@Size(min=2, message = " Compo requerido" )
	private String nombre;
	private String apellido;
	private String optativa;
	private String ciudadEstudios;
	private String idiomasAlumno;
	@Min(value=10, message = " No se permiten menores de edad en la pagina")
	@Max(value=100, message = " No se permiten edades mayores de 100 en la pagina")
	private int edad;
	@Email
	private String email;
	//@Pattern(regexp="[0-9]{5}", message="Solo 5 valores numericos")
	@CPostalMadrid
	private String codigoPostal;

}
