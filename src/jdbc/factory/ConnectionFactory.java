package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	
	public DataSource datasource;
	
	public ConnectionFactory() {
	    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("daniel@89@");
		comboPooledDataSource.setMaxPoolSize(10);
		
		this.datasource = comboPooledDataSource;
	}
	
	public Connection recuperarConexion()  {
		try {
		  return this.datasource.getConnection();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	


}
