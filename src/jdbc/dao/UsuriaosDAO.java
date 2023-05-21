package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.factory.ConnectionFactory;

public class UsuriaosDAO {

	public static boolean validarUsuario(String usuario, String contraseña) {

		ConnectionFactory con = new ConnectionFactory();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;

		try {

			connection = con.recuperarConexion();
			state = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?");
			state.setString(1, usuario);
			state.setString(2, contraseña);

			result = state.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (result != null)
					result.close();
				if (state != null)
					state.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
	}
}
