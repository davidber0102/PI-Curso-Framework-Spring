package mx.davdev.aspectos;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import mx.davdev.aop.Cliente;

@Aspect
@Component
@Order(2)
public class LoginConAspecto {
	
	// pointcuts para todo un paquete 
	// @Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* mx.davdev.aop.dao.*.*(..))")
	public void paraclientes() {}
	
	
	@Pointcut("paraclientes()")
	public void antesInsertarCliente(JoinPoint miJoin) {
		System.out.println("El usuario esta logeado");
		System.out.println("El perfil para insertar clientes es correcto");
		
		Object [] argumentos = miJoin.getArgs();
		
		for(Object temp: argumentos) {
			if(temp instanceof Cliente) {
				Cliente elCliente = (Cliente) temp;
					System.out.println("Nombre del Cliente: " + elCliente.getNombre());
					System.out.println("Tipo del Cliente: " + elCliente.getTipo());
			}	
		}
	}
}
