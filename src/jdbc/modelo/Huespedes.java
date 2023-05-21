package jdbc.modelo;

import java.sql.Date;

public class Huespedes {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private Date fechaDeNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer  id_reserva ;
	
	public Huespedes(Integer id, String nombre, String apellidos, Date fechaDeNacimiento, String nacionalidad,
			String telefono, Integer id_reserva) {
	
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}

	public Huespedes(String nombre, String apellidos, Date fechaDeNacimiento, String nacionalidad, String telefono,
			Integer id_reserva) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
