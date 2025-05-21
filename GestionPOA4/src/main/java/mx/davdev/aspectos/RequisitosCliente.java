package mx.davdev.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class RequisitosCliente {
	@Pointcut("mx.davdev.aspectos.LoginConAspecto.paraclientes()")
	public void requisitosCliente() {
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
	}

}
