package mx.davdev.spring.mvc.validacionesPersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPostalMadridValidacion implements ConstraintValidator<CPostalMadrid, String>  {
	
	@Override
	public void initialize(CPostalMadrid cpostal) {
		prefijoCodigoMadrid = cpostal.value();
	    }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		boolean valCodigo;
		
		if(arg0!=null) valCodigo= arg0.startsWith(prefijoCodigoMadrid);		
		else return valCodigo = true;
		
		return valCodigo;
	}
	private String prefijoCodigoMadrid;
}
