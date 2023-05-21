package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO(Connection co) {
		this.con = co;
		
	}
	
	public void guardarReserva(Reserva reserva) {
		
		try {
			
			PreparedStatement statement;
			statement = con.prepareStatement("INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_de_pago) "
					+ "VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setDate(1,reserva.getFechaE());
				statement.setDate(2, reserva.getFechaS());
				statement.setString(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try (resultSet){
					while(resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
						
						//System.out.println(String.format("Fue la realizada la reserva: %s", reserva));
					}
				}
			}
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Reserva> listar(){
		List<Reserva> reservas = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con.
					prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas");
			
			try(statement){
				statement.execute();
				
				final ResultSet resulset = statement.getResultSet();
				
				try(resulset){
					while(resulset.next()) {
						reservas.add(new Reserva(
								resulset.getInt("id"),
								resulset.getDate("fecha_entrada"),
								resulset.getDate("fecha_salida"),
								resulset.getString("valor"),
								resulset.getString("forma_de_pago"))
								);
					}
					
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return reservas;
	}
	
	public List<Reserva> listarPorId(String id){
		List<Reserva> reservas = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con.
					prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas WHERE ID = ?");
			
			try(statement){
				statement.setString(1, id);
				statement.execute();
				
				final ResultSet resulset = statement.getResultSet();
				
				try(resulset){
					while(resulset.next()) {
						reservas.add(new Reserva(
								resulset.getInt("id"),
								resulset.getDate("fecha_entrada"),
								resulset.getDate("fecha_salida"),
								resulset.getString("valor"),
								resulset.getString("forma_de_pago"))
								);
					}
					
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return reservas;
	}
	
	public int  actualizarReservas(Date fechaE ,Date fechaS, String valor, String forma_de_pago, Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE reservas SET "
					+ "fecha_entrada = ?, "
					+ "fecha_salida = ?, "
					+ "valor = ?, "
					+ "forma_de_pago = ? WHERE id = ?");
			
			try (statement){
				statement.setDate(1, fechaE);
				statement.setDate(2, fechaS);
				statement.setString(3, valor);
				statement.setString(4, forma_de_pago);
				statement.setInt(5, id);
				
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
		}catch(SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void eliminarReserva(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
			
			try(statement){
				statement.setInt(1, id);
				statement.execute();
				
			
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
