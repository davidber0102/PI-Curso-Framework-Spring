package mx.davdev.aspectos;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* mx.davdev.aop.servicios.*.getServicio(..))")
	public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable {
		System.out.println("----------Comienzo de acciones antes de llamada -----------------");
		
		Object resultado = elPoint.proceed(); // elPoint apunta al metodo destino
		
		System.out.println("----------Tareas despues de llamada -----------------");
		
		return resultado;
		
	}
	
	
	
	// proceso de listrdo de clientes despues de ejecucion
	@AfterReturning(pointcut="execution(* mx.davdev.aop.dao.ClienteDAO.encuentraCliente(..))", returning = "listaDeClientes")
	public void tareaTrasEncontrarClientes(List<Cliente> listaDeClientes) {
		for(Cliente cl: listaDeClientes) {
			if(cl.getTipo()=="VIP") {				
				procesadoDatosAfterReturning(listaDeClientes);
				System.out.println("Existen clientes VIP en el listado" + cl.getNombre());
			}
		}
	}
	
	@AfterThrowing(pointcut="execution(* mx.davdev.aop.dao.ClienteDAO.encuentraCliente(..))", throwing="LaExcepcion")
	public void procesandoDatosAfterExceptionEncuentraClientes(Throwable LaExcepcion) {
		System.out.println("Se estan procesando los datos de clientes");
	}
	
	
	
	@After("execution(* mx.davdev.aop.dao.ClienteDAO.encuentraCliente(..))")
	public void ejecuntandoTareasConYSinExcepcion(JoinPoint elJoin) {
		System.out.println("Ejecuntando tareas SIEMPRE!!!!");
	}
	
		
	private void procesadoDatosAfterReturning(List<Cliente> listaDeClientes) {
		for(Cliente cl: listaDeClientes) {
			String datosProcesados= "V.I.P" + cl.getNombre().toUpperCase();
			cl.setNombre(datosProcesados);
		}
	}

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
