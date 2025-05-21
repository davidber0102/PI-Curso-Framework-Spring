package mx.davdev.aop.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import mx.davdev.aop.Cliente;

@Component
public class ClienteDAO {	
	public void insertaCliente(Cliente elCliente, String tipo){
		System.out.println("Trabajo realizado OK. Cliente Insertado con exito");
		// return "Cliente insertado correctamente";	
	}
	
	public List<Cliente> encuentraCliente(boolean miParam){
		if(miParam) throw new RuntimeException(" ¡¡ ERROR!! -- No se ha podido procesar la peticion");
		
		
		List<Cliente> listaClientes = new ArrayList<>();
		// simular clientes devueltos por bbdd
		
		Cliente cl1 = new Cliente("Maria", "Normal");
		Cliente cl2 = new Cliente("Anna", "Normal");
		Cliente cl3 = new Cliente("Sandra", "VIP");
		Cliente cl4 = new Cliente("Antonio", "Normal");
		
		// AGREGAR CLIENTES A LISTA
		listaClientes.add(cl1);
		listaClientes.add(cl2);
		listaClientes.add(cl3);
		listaClientes.add(cl4);
		
		System.out.println("Ejecuccion Finalizada del metodo encuentr clientes()");
		
		return listaClientes;
		
	}
	
}
