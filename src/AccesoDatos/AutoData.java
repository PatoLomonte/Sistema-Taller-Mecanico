package AccesoDatos;

import Entidades.Auto;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AutoData {

    private Connection con = null;
    private ClienteData clienteData = new ClienteData();

    public AutoData() {
        con = Conexion.getConexion();
    }

    public void guardarAuto(Auto auto) {

        String sql = "INSERT INTO auto(id_cliente, vehiculo, patente, kilometros, observacion, inactivo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, auto.getCliente().getIdCliente());
            ps.setString(2, auto.getVehiculo());
            ps.setString(3, auto.getPatente());
            ps.setInt(4, auto.getKilometros());
            ps.setString(5, auto.getObservacion());
            ps.setBoolean(6, false);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Auto guardado correctamente.");

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar el auto.");
            System.out.println("Error guardarAuto: " + ex.getMessage());
        }
    }

    public Auto buscarAutoPorId(int idAuto) {

        Auto auto = null;

        String sql = "SELECT * FROM auto WHERE id_auto = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAuto);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cliente cliente =
                        clienteData.buscarClientePorId(rs.getInt("id_cliente"));

                auto = new Auto();

                auto.setIdAuto(rs.getInt("id_auto"));
                auto.setCliente(cliente);
                auto.setVehiculo(rs.getString("vehiculo"));
                auto.setPatente(rs.getString("patente"));
                auto.setKilometros(rs.getInt("kilometros"));
                auto.setObservacion(rs.getString("observacion"));
                auto.setInactivo(rs.getBoolean("inactivo"));
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al buscar el auto.");
            System.out.println("Error buscarAutoPorId: " + ex.getMessage());
        }

        return auto;
    }

    public ArrayList<Auto> buscarAutosPorPatente(String patente) {

        ArrayList<Auto> lista = new ArrayList<>();

        String sql = "SELECT * FROM auto WHERE patente LIKE ? AND inactivo = false ORDER BY patente";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + patente + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente =
                        clienteData.buscarClientePorId(rs.getInt("id_cliente"));

                Auto auto = new Auto();

                auto.setIdAuto(rs.getInt("id_auto"));
                auto.setCliente(cliente);
                auto.setVehiculo(rs.getString("vehiculo"));
                auto.setPatente(rs.getString("patente"));
                auto.setKilometros(rs.getInt("kilometros"));
                auto.setObservacion(rs.getString("observacion"));
                auto.setInactivo(rs.getBoolean("inactivo"));

                lista.add(auto);
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al buscar autos por patente.");
            System.out.println("Error buscarAutosPorPatente: " + ex.getMessage());
        }

        return lista;
    }
    
    
    
    
    public void darDeBajaAuto(int idAuto) {

    String sql = "UPDATE auto SET inactivo = true WHERE id_auto = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idAuto);

        int filas = ps.executeUpdate();

        if (filas == 1) {
            JOptionPane.showMessageDialog(null, "Auto dado de baja correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el auto.");
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al dar de baja el auto.");
        System.out.println("Error darDeBajaAuto: " + ex.getMessage());
    }
}
    
    
    
    
}
