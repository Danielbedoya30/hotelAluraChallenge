package jdbc.controller;

import java.sql.Date;
import java.util.List;

import jdbc.dao.HuespedesDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Huespedes;

public class HuespedesController {
	
	private HuespedesDAO huespedesDao;
	
	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedesDao = new HuespedesDAO(factory.recuperarConexion());
		
	}
	
	public void guardarHuesped(Huespedes huespedes) {
		this.huespedesDao.guardarHuesped(huespedes);
	}
	
	public List<Huespedes> listarHuespedes(){
		return this.huespedesDao.listar();
	}
	
	public List<Huespedes>listarHuespedesPorId(String id){
		return this.huespedesDao.listarPorId(id);
	}
	
	public void actualizarHuespedes(String nombre ,String apellidos, Date fechaDeNacimiento, String nacionalidad, String telefono, Integer id_reserva, Integer id) {
		this.huespedesDao.actualizarHuespedes(nombre, apellidos, fechaDeNacimiento, nacionalidad, telefono, id_reserva, id);
	}
	
	public void eliminarHuespedes(Integer id) {
		this.huespedesDao.eliminarHuespedes(id);
	}

}
