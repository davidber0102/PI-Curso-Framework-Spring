package mx.davdev.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class RequisitosTabla {
	
	@Pointcut("mx.davdev.aspectos.LoginConAspecto.paraclientes()")
	public void requisitosTabla() {
		System.out.println("En la  tabla de la BBDD, cuenta con menos de 300 registros. Puedes insertar nuevo Cliente");
	}

}
