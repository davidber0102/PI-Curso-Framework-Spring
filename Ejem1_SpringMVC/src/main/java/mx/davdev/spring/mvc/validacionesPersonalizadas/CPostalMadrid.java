package mx.davdev.spring.mvc.validacionesPersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.*;

@Constraint(validatedBy = CPostalMadridValidacion.class) // futura clase que contendra la logica de la validacion 
@Target({ElementType.METHOD, ElementType.FIELD })		// destino de nuestra validacion a metodos y campos
@Retention(RetentionPolicy.RUNTIME)						// cheque la anotacion en timpo de ejecucion
public @interface CPostalMadrid {
	
	//Definir el codigo postal por defecto
		public String value() default "28";
	
	// Definir el mensaje de error
		public String message() default "El C. Postal debe comenzar por el numero 28: ";	
	
	// definir los grupos
		Class<?>[] groups() default {}	;
	
	// definir los payloads  
		Class<? extends Payload>[] payload() default {};
}
