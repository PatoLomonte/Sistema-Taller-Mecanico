package AccesoDatos;

import Entidades.Casa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CasaData {


    private Connection con = null;

public CasaData() {
    con = Conexion.getConexion();
}




public ArrayList<Casa> listarCasas() {

    ArrayList<Casa> lista = new ArrayList<>();

    String sql = "SELECT * FROM casa WHERE inactivo = false ORDER BY nombre";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Casa casa = new Casa();

            casa.setIdCasa(rs.getInt("id_casa"));
            casa.setNombre(rs.getString("nombre"));
            casa.setTelefono(rs.getString("telefono"));
            casa.setDireccion(rs.getString("direccion"));
            casa.setObservacion(rs.getString("observacion"));
            casa.setSaldo(rs.getInt("saldo"));
            casa.setInactivo(rs.getBoolean("inactivo"));

            lista.add(casa);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al listar casas.");
    }

    return lista;
}





public void guardarCasa(Casa casa) {

    String sql = "INSERT INTO casa(nombre, telefono, direccion, observacion, saldo, inactivo) VALUES (?, ?, ?, ?, ?, ?)";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, casa.getNombre());
        ps.setString(2, casa.getTelefono());
        ps.setString(3, casa.getDireccion());
        ps.setString(4, casa.getObservacion());
        ps.setInt(5, casa.getSaldo());
        ps.setBoolean(6, false);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Casa guardada correctamente.");

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al guardar la casa.");
    }
}




public Casa buscarCasaPorId(int idCasa) {

    Casa casa = null;

    String sql = "SELECT * FROM casa WHERE id_casa = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCasa);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            casa = new Casa();

            casa.setIdCasa(rs.getInt("id_casa"));
            casa.setNombre(rs.getString("nombre"));
            casa.setTelefono(rs.getString("telefono"));
            casa.setDireccion(rs.getString("direccion"));
            casa.setObservacion(rs.getString("observacion"));
            casa.setSaldo(rs.getInt("saldo"));
            casa.setInactivo(rs.getBoolean("inactivo"));
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al buscar la casa.");
    }

    return casa;
}




public void modificarCasa(Casa casa) {

    String sql = "UPDATE casa SET nombre = ?, telefono = ?, direccion = ?, observacion = ?, saldo = ? WHERE id_casa = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, casa.getNombre());
        ps.setString(2, casa.getTelefono());
        ps.setString(3, casa.getDireccion());
        ps.setString(4, casa.getObservacion());
        ps.setInt(5, casa.getSaldo());
        ps.setInt(6, casa.getIdCasa());

        int filas = ps.executeUpdate();

        if (filas == 1) {
            JOptionPane.showMessageDialog(null, "Casa modificada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la casa.");
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al modificar la casa.");
    }
}




public void sumarSaldo(int idCasa, int monto) {

    String sql = "UPDATE casa SET saldo = saldo + ? WHERE id_casa = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, monto);
        ps.setInt(2, idCasa);

        ps.executeUpdate();

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al actualizar el saldo.");
    }
}




public void restarSaldo(int idCasa, int monto) {

    String sql = "UPDATE casa SET saldo = saldo - ? WHERE id_casa = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, monto);
        ps.setInt(2, idCasa);

        ps.executeUpdate();

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al restar el saldo.");
    }
}




public void desactivarCasa(int idCasa) {

    String sql = "UPDATE casa SET inactivo = true WHERE id_casa = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idCasa);

        int filas = ps.executeUpdate();

        if (filas == 1) {
            JOptionPane.showMessageDialog(null, "Casa eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la casa.");
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al eliminar la casa.");
    }
}


    
}
