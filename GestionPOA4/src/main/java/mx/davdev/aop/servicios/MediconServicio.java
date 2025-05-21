package mx.davdev.aop.servicios;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MediconServicio {
	
	public String getServicio() {
		
		System.out.println("********* EL METODO REALIZANDO SUS TAREAS***********************");
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Servicios terminados";
		
	}

}
