package mx.davdev.aop.dao;

import org.springframework.stereotype.Component;

import mx.davdev.aop.Cliente;

@Component
public class ClienteDAO {	
	public void insertaCliente(Cliente elCliente){
		System.out.println("Trabajo realizado OK. Cliente Insertado con exito");
		// return "Cliente insertado correctamente";	
	}
}
