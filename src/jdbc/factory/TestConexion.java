package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory con = new ConnectionFactory();
		Connection conexion = con.recuperarConexion();
		
		System.out.println("Conexion correcta");
		conexion.close();
		
		System.out.println("Conexion cerrada correctamente");
		
				
		
	}

}
