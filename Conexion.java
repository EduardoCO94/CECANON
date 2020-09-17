

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion
{
    private final String url = "jdbc:mysql://localhost/gestion";
	private final String usuario = "root";
	private final String contraseña = "";
	private Connection conectar = null;

	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conectar = DriverManager.getConnection(url, "root", "");

		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
		}
		return conectar;

	}
    
}
