package AccesoDatos;

import Entidades.Gasto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GastoData {

    private Connection con = null;

    public GastoData() {
        con = Conexion.getConexion();
    }

    public void guardarGasto(Gasto gasto) {

        String sql = "INSERT INTO gasto(fecha, categoria, descripcion, monto, observacion, anulado) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, java.sql.Timestamp.valueOf(gasto.getFecha()));
            ps.setString(2, gasto.getCategoria());
            ps.setString(3, gasto.getDescripcion());
            ps.setInt(4, gasto.getMonto());
            ps.setString(5, gasto.getObservacion());
            ps.setBoolean(6, false);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Gasto guardado correctamente.");

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar el gasto.");
            System.out.println("Error al guardar gasto: " + ex.getMessage());
        }
    }
    
    
    
    
    
    public ArrayList<Gasto> listarGastosFiltro(int mes, int anio) {

    ArrayList<Gasto> lista = new ArrayList<>();

    String sql = "SELECT id_gasto, fecha, categoria, descripcion, monto, observacion, anulado FROM gasto WHERE anulado = false ";

    if (mes != 0) {
        sql += "AND MONTH(fecha) = ? ";
    }

    if (anio != 0) {
        sql += "AND YEAR(fecha) = ? ";
    }

    sql += "ORDER BY fecha DESC";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        int indice = 1;

        if (mes != 0) {
            ps.setInt(indice, mes);
            indice++;
        }

        if (anio != 0) {
            ps.setInt(indice, anio);
            indice++;
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Gasto gasto = new Gasto();

            gasto.setIdGasto(rs.getInt("id_gasto"));
            gasto.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            gasto.setCategoria(rs.getString("categoria"));
            gasto.setDescripcion(rs.getString("descripcion"));
            gasto.setMonto(rs.getInt("monto"));
            gasto.setObservacion(rs.getString("observacion"));
            gasto.setAnulado(rs.getBoolean("anulado"));

            lista.add(gasto);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al listar los gastos.");
        System.out.println("Error al listar gastos: " + ex.getMessage());
    }

    return lista;
}
    
    
    
    
    
    public Gasto buscarGastoPorId(int idGasto) {

    Gasto gasto = null;

    String sql =
        "SELECT id_gasto, fecha, categoria, descripcion, monto, observacion, anulado " +
        "FROM gasto " +
        "WHERE id_gasto = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idGasto);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            gasto = new Gasto();

            gasto.setIdGasto(rs.getInt("id_gasto"));
            gasto.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            gasto.setCategoria(rs.getString("categoria"));
            gasto.setDescripcion(rs.getString("descripcion"));
            gasto.setMonto(rs.getInt("monto"));
            gasto.setObservacion(rs.getString("observacion"));
            gasto.setAnulado(rs.getBoolean("anulado"));
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al buscar el gasto.");
        System.out.println("Error al buscar gasto: " + ex.getMessage());
    }

    return gasto;
}
    
    
    
    
    
    
    public void modificarGasto(Gasto gasto) {

    String sql =
        "UPDATE gasto SET fecha = ?, categoria = ?, descripcion = ?, monto = ?, observacion = ? " +
        "WHERE id_gasto = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setTimestamp(1, java.sql.Timestamp.valueOf(gasto.getFecha()));
        ps.setString(2, gasto.getCategoria());
        ps.setString(3, gasto.getDescripcion());
        ps.setInt(4, gasto.getMonto());
        ps.setString(5, gasto.getObservacion());
        ps.setInt(6, gasto.getIdGasto());

        int filas = ps.executeUpdate();

        if (filas == 1) {
            JOptionPane.showMessageDialog(null, "Gasto modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el gasto.");
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al modificar el gasto.");
        System.out.println("Error al modificar gasto: " + ex.getMessage());
    }
}
    
    
    
    
    
    public void anularGasto(int idGasto) {

    String sql = "UPDATE gasto SET anulado = true WHERE id_gasto = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idGasto);

        int filas = ps.executeUpdate();

        if (filas == 1) {
            JOptionPane.showMessageDialog(null, "Gasto anulado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el gasto.");
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al anular el gasto.");
        System.out.println("Error al anular gasto: " + ex.getMessage());
    }
}
    
    
    
    
}
