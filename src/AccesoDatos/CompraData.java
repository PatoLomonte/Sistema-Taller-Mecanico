package AccesoDatos;

import Entidades.Casa;
import Entidades.Compra;
import Entidades.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompraData {

    private Connection con = null;

    public CompraData() {
        con = Conexion.getConexion();
    }

    public int guardarCompra(Compra compra) {

        int idGenerado = -1;

        String sql = "INSERT INTO compra(id_casa, fecha, numero_comprobante, total, observacion) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, compra.getCasa().getIdCasa());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(compra.getFecha()));
            ps.setString(3, compra.getNumeroComprobante());
            ps.setInt(4, compra.getTotal());
            ps.setString(5, compra.getObservacion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idGenerado = rs.getInt(1);
                compra.setIdCompra(idGenerado);
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar la compra.");
        }

        return idGenerado;
    }

    public void guardarDetalleCompra(DetalleCompra detalle) {

        String sql = "INSERT INTO detalle_compra(id_compra, cantidad, codigo, descripcion, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, detalle.getCompra().getIdCompra());
            ps.setInt(2, detalle.getCantidad());
            ps.setString(3, detalle.getCodigo());
            ps.setString(4, detalle.getDescripcion());
            ps.setInt(5, detalle.getPrecioUnitario());
            ps.setInt(6, detalle.getSubtotal());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar el detalle de la compra.");
        }
    }
    
    
    
    
    
    
    
    public ArrayList<Compra> listarComprasPorCasa(Casa casa) {

    ArrayList<Compra> lista = new ArrayList<>();

    String sql = "SELECT id_compra, fecha, numero_comprobante, total, observacion "
               + "FROM compra "
               + "WHERE id_casa = ? AND anulado = false "
               + "ORDER BY fecha DESC";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, casa.getIdCasa());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Compra compra = new Compra();

            compra.setIdCompra(rs.getInt("id_compra"));
            compra.setCasa(casa);
            compra.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            compra.setNumeroComprobante(rs.getString("numero_comprobante"));
            compra.setTotal(rs.getInt("total"));
            compra.setObservacion(rs.getString("observacion"));

            lista.add(compra);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al listar las compras de la casa.");
    }

    return lista;
}
    
    
    
    
    
    
    public ArrayList<DetalleCompra> obtenerDetalleCompra(int idCompra) {

    ArrayList<DetalleCompra> lista = new ArrayList<>();

    String sql = "SELECT cantidad, codigo, descripcion, precio_unitario, subtotal FROM detalle_compra WHERE id_compra = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idCompra);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            DetalleCompra detalle = new DetalleCompra();

            detalle.setCantidad(rs.getInt("cantidad"));
            detalle.setCodigo(rs.getString("codigo"));
            detalle.setDescripcion(rs.getString("descripcion"));
            detalle.setPrecioUnitario(rs.getInt("precio_unitario"));
            detalle.setSubtotal(rs.getInt("subtotal"));

            lista.add(detalle);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
            null,
            "Error al obtener el detalle de la compra."
        );
    }

    return lista;
}
    
    
    
    
    public void anularCompra(int idCompra) {

    String sql = "UPDATE compra SET anulado = true WHERE id_compra = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idCompra);

        ps.executeUpdate();

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al anular la compra.");
    }
}
    
    
    
    
    
    
    public ArrayList<Compra> listarComprasPorCasaFiltro(Casa casa, int mes, int anio) {

    ArrayList<Compra> lista = new ArrayList<>();

    String sql =
        "SELECT id_compra, fecha, numero_comprobante, total, observacion " +
        "FROM compra " +
        "WHERE id_casa = ? " +
        "AND anulado = false ";

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

        ps.setInt(indice, casa.getIdCasa());
        indice++;

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

            Compra compra = new Compra();

            compra.setIdCompra(rs.getInt("id_compra"));
            compra.setCasa(casa);
            compra.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            compra.setNumeroComprobante(rs.getString("numero_comprobante"));
            compra.setTotal(rs.getInt("total"));
            compra.setObservacion(rs.getString("observacion"));

            lista.add(compra);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al listar las compras filtradas.");
    }

    return lista;
}
    
  
    
    
}
