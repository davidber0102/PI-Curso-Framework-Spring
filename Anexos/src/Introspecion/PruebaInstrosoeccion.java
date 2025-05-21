package Introspecion;

import java.lang.reflect.*;
import java.util.Scanner;

public class PruebaInstrosoeccion {
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Introduce el nombre de la clase");
		
		String nombreClase;
		
		nombreClase = entrada.next();
		
		// imprimir clase y super clase
		
		try {
			Class cl = Class.forName(nombreClase);
			Class superCl = cl.getSuperclass();
			System.out.println("Clase " + nombreClase);
			
			if(superCl!=null && superCl!=Object.class) {
				System.out.println("Extends" + superCl.getName());
			}
			System.out.println();
			
			imprimirConstructores(cl);
			System.out.println();
			
			imprimirMetodos(cl);
			System.out.println();
			
			imprimirCampos(cl);
			System.out.println();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void imprimirConstructores(Class cl) {
		Constructor[] constructores = cl.getDeclaredConstructors();
		System.out.println("------------------Constructores---------------------");
		for(Constructor c:  constructores) {
			String nombre = c.getName();
			System.out.print("  " + Modifier.toString( c.getModifiers()));
			System.out.print("  " + nombre + "(");
			// imprimir parametros
			Class [] tipoParametros = c.getParameterTypes();
			for (int i=0; i<tipoParametros.length; i++) {
				if(i>0) System.out.print(",  ");
				System.out.print(tipoParametros[i].getName());
			}
			System.out.println(" ); ");	
		}
		System.out.println("\n------------------------------------------------------");
	}
	
	// imprime todos los metodos de la clase
	public static void imprimirMetodos(Class cl) {
		Method [] metodos = cl.getDeclaredMethods();
		System.out.println("------------------Metodos de Clase---------------------");
		for(Method m: metodos) {
			Class tipoDevuelto = m.getReturnType();
			String nombre = m.getName();
			
			// imprime modificadores, tipo y nombre
			System.out.print("  " + Modifier.toString(m.getModifiers()));
			System.out.print("  " + tipoDevuelto.getName() + " " + nombre + "( ");
			
			// imprime tipo de parametros
			Class [] tParam = m.getParameterTypes();
			for (int i=0; i<tParam.length; i++) {
				if(i>0) System.out.print(",  ");
				System.out.print(tParam[i].getName());
			}
			System.out.println(" ); ");	
		}
		System.out.println("\n-----------------------------------------------------------------");
	}
	
	// impirme los campos de la clase
	public static void imprimirCampos(Class cl) {
		Field[] campos = cl.getDeclaredFields();
		System.out.println("------------------Campos de clase---------------------");
		for(Field f:campos) {
			Class tipoCampo = f.getType();
			String nombre = f.getName();
			
			// imprimir campos
			System.out.print("  " + Modifier.toString(f.getModifiers()));
			System.out.print("  " + tipoCampo.getName() + " " + nombre + "; ");

		}
		System.out.println("\n-----------------------------------------------------");
	}

}
