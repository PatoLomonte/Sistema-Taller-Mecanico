package AccesoDatos;

import Entidades.Arreglo;
import Entidades.Auto;
import Entidades.DetalleArreglo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArregloData {

    private Connection con = null;

    public ArregloData() {
        con = Conexion.getConexion();
    }

    public ArrayList<Arreglo> listarArreglosPorAuto(Auto auto) {

        ArrayList<Arreglo> lista = new ArrayList<>();

        String sql =
            "SELECT id_arreglo, fecha, kilometros, total, observacion, anulado " +
            "FROM arreglo " +
            "WHERE id_auto = ? AND anulado = false " +
            "ORDER BY fecha DESC";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, auto.getIdAuto());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Arreglo arreglo = new Arreglo();

                arreglo.setIdArreglo(rs.getInt("id_arreglo"));
                arreglo.setAuto(auto);
                arreglo.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                arreglo.setKilometros(rs.getInt("kilometros"));
                arreglo.setTotal(rs.getInt("total"));
                arreglo.setObservacion(rs.getString("observacion"));
                arreglo.setAnulado(rs.getBoolean("anulado"));

                lista.add(arreglo);
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al listar los arreglos.");
            System.out.println("Error listarArreglosPorAuto: " + ex.getMessage());
        }

        return lista;
    }
    
    
    
    
    public int guardarArreglo(Arreglo arreglo) {

    int idGenerado = -1;

    String sql = "INSERT INTO arreglo(id_auto, fecha, kilometros, total, observacion, anulado) "
               + "VALUES (?, ?, ?, ?, ?, ?)";

    try {

        PreparedStatement ps = con.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        );

        ps.setInt(1, arreglo.getAuto().getIdAuto());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(arreglo.getFecha()));
        ps.setInt(3, arreglo.getKilometros());
        ps.setInt(4, arreglo.getTotal());
        ps.setString(5, arreglo.getObservacion());
        ps.setBoolean(6, false);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            idGenerado = rs.getInt(1);
            arreglo.setIdArreglo(idGenerado);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al guardar el arreglo.");
        System.out.println("Error guardarArreglo: " + ex.getMessage());
    }

    return idGenerado;
}
    
    
    
    public void guardarDetalleArreglo(DetalleArreglo detalle) {

    String sql = "INSERT INTO detalle_arreglo(id_arreglo, descripcion, importe) "
               + "VALUES (?, ?, ?)";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, detalle.getArreglo().getIdArreglo());
        ps.setString(2, detalle.getDescripcion());
        ps.setInt(3, detalle.getImporte());

        ps.executeUpdate();

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al guardar el detalle del arreglo.");
        System.out.println("Error guardarDetalleArreglo: " + ex.getMessage());
    }
}
    

    
    
    
    public ArrayList<DetalleArreglo> obtenerDetalleArreglo(int idArreglo) {

    ArrayList<DetalleArreglo> lista = new ArrayList<>();

    String sql =
        "SELECT descripcion, importe FROM detalle_arreglo WHERE id_arreglo = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idArreglo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            DetalleArreglo detalle = new DetalleArreglo();

            detalle.setDescripcion(rs.getString("descripcion"));
            detalle.setImporte(rs.getInt("importe"));

            lista.add(detalle);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al obtener el detalle del arreglo.");
        System.out.println("Error obtenerDetalleArreglo: " + ex.getMessage());
    }

    return lista;
}
    
    
    
    
    
    public Arreglo buscarArregloPorId(int idArreglo, Auto auto) {

    Arreglo arreglo = null;

    String sql =
        "SELECT id_arreglo, fecha, kilometros, total, observacion, anulado " +
        "FROM arreglo " +
        "WHERE id_arreglo = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idArreglo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            arreglo = new Arreglo();

            arreglo.setIdArreglo(rs.getInt("id_arreglo"));
            arreglo.setAuto(auto);
            arreglo.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            arreglo.setKilometros(rs.getInt("kilometros"));
            arreglo.setTotal(rs.getInt("total"));
            arreglo.setObservacion(rs.getString("observacion"));
            arreglo.setAnulado(rs.getBoolean("anulado"));
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al buscar el arreglo.");
        System.out.println("Error buscarArregloPorId: " + ex.getMessage());
    }

    return arreglo;
}
    
    
    
}


