package mx.davdev.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PruebasJDBC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creamos variables con la el apoyo de la libreria y usuario y contraseña
		String jdbcURL="jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		String nomBd = "BBDD pruerbas Hibernate";
		String usuario= "root";
		String psw = "dBd#C4rt0$202A";
		try {		
			System.out.println("Accediendo a la Base de Datos!!");
		// 1 .- crear connexion			
			Connection myConex = DriverManager.getConnection(jdbcURL, usuario, psw);		
			System.out.println("Conexion exitosa a la Base de Datos!! " + nomBd);
		// 2.- crear objeto statement
			// Statement s = myConex.createStatement();
		
		// 3.- ejecutar la instruccion sql
			// ResultSet r = s.executeQuery("SELECT * FROM facturas");
			
		// 4.- LEER EL RESULSET			
			// while(r.next()) {
			// 	System.out.println(r.getString("DNI") + " " + r.getString("MATRICULA") + " "+ r.getDate("FECHA_VENTA") + " " + r.getFloat("IMPUESTO"));
			// }	
		}catch(Exception e){
			System.out.println("Sin Conexion a Base de Datos!!");
			e.printStackTrace();
		}
	}
}
