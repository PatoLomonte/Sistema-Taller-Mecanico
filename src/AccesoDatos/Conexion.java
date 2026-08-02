package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/"; 
    private static final String DB = "taller";
    private static final String usuario = "root";
    private static final String password = "";
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConexion(){
        if(connection==null){
            try {
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    System.out.println("Driver cargado exitosamente");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la carga del Driver");
                }
                connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/taller", "root","");
                System.out.println("Conexion a base de datos exitosa");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la conexion a la base de datos");
            }
            
        }
        return connection;
    }
}

