package jdbc.modelo;

import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private Date fechaE;
	private Date fechaS;
	private String valor;
	private String FormaPago;
	
	public Reserva(Date fechaE, Date fechaS, String valor, String formaPago) {
		
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.FormaPago = formaPago;
	}

	public Reserva(Integer id, Date fechaE, Date fechaS, String valor, String formaPago) {
		
		this.id = id;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.FormaPago = formaPago;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFechaE() {
		return fechaE;
	}

	public void setFechaE(Date fechaE) {
		this.fechaE = fechaE;
	}

	public Date getFechaS() {
		return fechaS;
	}

	public void setFechaS(Date fechaS) {
		this.fechaS = fechaS;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return FormaPago;
	}

	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

	
	
	
	

	


}
