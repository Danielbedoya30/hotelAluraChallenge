package jdbc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import jdbc.dao.UsuriaosDAO;
import views.Login;
import views.MenuUsuario;

public class UsuarioController implements ActionListener {
	
	private Login vista;
	
	public UsuarioController(Login vista) {
		this.vista = vista;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String usuario = vista.getUsuario();
		String contraseña = vista.getContraseña();
		
		if(UsuriaosDAO.validarUsuario(usuario, contraseña)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista, "Usuario o contraseña no validos");
		}
	}
	

	

}
