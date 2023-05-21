package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Huespedes;
import jdbc.modelo.Reserva;

public class HuespedesDAO {
	
	private  Connection con;
	
	public HuespedesDAO (Connection con) {
		this.con = con;
		
	}
	
	public void guardarHuesped (Huespedes huespedes) {
		try {
			
			PreparedStatement statement;
			statement = con.prepareStatement("INSERT INTO huespedes(nombre, apellidos, fecha_de_nacimiento, nacionalidad, telefono, id_reserva) "
					+ "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try (statement){
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellidos());
				statement.setDate(3, huespedes.getFechaDeNacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getId_reserva());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try (resultSet){
					while(resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));;
					}
				}
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> listar(){
		List<Huespedes> huespedes = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con.
					prepareStatement("SELECT id, nombre, apellidos, fecha_de_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes");
			
			try(statement){
				statement.execute();
				
				final ResultSet resulset = statement.getResultSet();
				
				try(resulset){
					while(resulset.next()) {
						huespedes.add(new Huespedes(
								resulset.getInt("id"),
								resulset.getString("nombre"),
								resulset.getString("apellidos"),
								resulset.getDate("fecha_de_nacimiento"),
								resulset.getString("nacionalidad"),
								resulset.getString("telefono"),
								resulset.getInt("id_reserva"))
								
								);
					}
					
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return huespedes;
	}
	
	public List<Huespedes> listarPorId(String id){
		List<Huespedes> huespedes = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con.
					prepareStatement("SELECT id, nombre, apellidos, fecha_de_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE ID = ?");
			
			try(statement){
				statement.setString(1, id);
				statement.execute();
				
				final ResultSet resulset = statement.getResultSet();
				
				try(resulset){
					while(resulset.next()) {
						huespedes.add(new Huespedes(
								resulset.getInt("id"),
								resulset.getString("nombre"),
								resulset.getString("apellidos"),
								resulset.getDate("fecha_de_nacimiento"),
								resulset.getString("nacionalidad"),
								resulset.getString("telefono"),
								resulset.getInt("id_reserva"))
								
								);
					}
					
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return huespedes;
	
	}
	
	public int  actualizarHuespedes(String nombre ,String apellidos, Date fechaDeNacimiento, String nacionalidad, String telefono, Integer id_reserva, Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET "
					+ "nombre = ?, "
					+ "apellidos = ?, "
					+ "fecha_de_nacimiento = ?, "
					+ "nacionalidad = ?, "
					+"telefono = ?, "
					+ "id_reserva = ? WHERE id = ?");
			
			try (statement){
				statement.setString(1, nombre);
				statement.setString(2, apellidos);
				statement.setDate(3, fechaDeNacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, id_reserva);
				statement.setInt(7, id);
				
				
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
		}catch(SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void eliminarHuespedes(Integer id) {
		
			try {
				final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
				
				try(statement){
					statement.setInt(1, id);
					statement.execute();
					
				
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
