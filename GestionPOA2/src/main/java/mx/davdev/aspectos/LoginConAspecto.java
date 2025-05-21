package mx.davdev.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	// pointcuts para todo un paquete 
	// @Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* mx.davdev.aop.dao.*.*(..))")
	private void paraclientes() {}
	
	// pointcuts paragetters
	@Pointcut("execution(* mx.davdev.aop.dao.*.get*(..))")
	private void paraGetters() {}
	
	// pointcuts para setters
	@Pointcut("execution(* mx.davdev.aop.dao.*.set*(..))")
	private void paraSetters() {}
	
	// pointcuts comnibanados
	@Pointcut("paraclientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetterSetter() {}
	
	//@Pointcut("paraclientes()")
	@Pointcut("paqueteExceptoGetterSetter()")
	public void antesInsertarCliente() {
		System.out.println("El usuario esta logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	//@Pointcut("paraclientes()")
	public void requisitosCliente() {
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
	}
	
	//@Pointcut("paraclientes()")
	public void requisitosTabla() {
		System.out.println("En la  tabla de la BBDD, cuenta con menos de 300 registros. Puedes insertar nuevo Cliente");
	}

}
