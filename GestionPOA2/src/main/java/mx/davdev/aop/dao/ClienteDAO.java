package mx.davdev.aop.dao;
import org.springframework.stereotype.Component;
import mx.davdev.aop.Cliente;

@Component
public class ClienteDAO {	
	public void insertaCliente(Cliente elCliente){
		System.out.println("Trabajo realizado OK. Cliente Insertado con exito");
		// return "Cliente insertado correctamente";	
	}
	
	public String getValoracionclienteNornal() {
		System.out.println("Obteniendo valoracion del cliente");
		return valoracionclienteNornal;
	}
	public void setValoracionclienteNornal(String valoracionclienteNornal) {
		System.out.println("Estableciendo valoracion del cliente");
		this.valoracionclienteNornal = valoracionclienteNornal;
	}
	public String getCodigoClienteNormal() {
		System.out.println("Obteniendo Codigo de cliente");
		return codigoClienteNormal;
	}
	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("Estableciendo Codigo de cliente");
		this.codigoClienteNormal = codigoClienteNormal;
	}

	private String valoracionclienteNornal;
	private String codigoClienteNormal;
}
