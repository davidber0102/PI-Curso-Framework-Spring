package mx.davdev.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	@Pointcut("paraclientes()")
	private void paraclientes() {}
	
	@Before("execution(public * insertaCliente*(..))")
	public void antesInsertarCliente() {
		System.out.println("El usuario esta logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	@Pointcut("paraclientes()")
	public void requisitosCliente() {
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
	}
	
	@Pointcut("paraclientes()")
	public void requisitosTabla() {
		System.out.println("En la  tabla de la BBDD, cuenta con menos de 300 registros. Puedes insertar nuevo Cliente");
	}

}
