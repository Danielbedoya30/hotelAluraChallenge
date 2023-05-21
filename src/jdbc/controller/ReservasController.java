package jdbc.controller;

import java.sql.Date;
import java.util.List;

import jdbc.dao.ReservaDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

public class ReservasController {
	
	private ReservaDAO  reservaDao ;
	
	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.recuperarConexion());
	}
	
	public void guardarReserva(Reserva reserva) {
		this.reservaDao.guardarReserva(reserva);
	}
	
	public List<Reserva> listar(){
		return this.reservaDao.listar();
	}
	
	public List<Reserva> listarPorId(String id){
		return this.reservaDao.listarPorId(id);
	}
	
	public void actualizarReserva(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservaDao.actualizarReservas(fechaE, fechaS, valor, formaPago, id);
	}
	
	public void eliminarReserva(Integer id) {
		this.reservaDao.eliminarReserva(id);
	}

}
