package AccesoDatos;

import Entidades.Casa;
import Entidades.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PagoData {

    private Connection con = null;

    public PagoData() {
        con = Conexion.getConexion();
    }

    public void registrarPago(Pago pago) {

        String sql = "INSERT INTO pago(id_casa, fecha, monto, observacion) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pago.getCasa().getIdCasa());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(pago.getFecha()));
            ps.setInt(3, pago.getMonto());
            ps.setString(4, pago.getObservacion());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al registrar el pago.");
        }
    }
    
    
    
    
    public ArrayList<Pago> listarPagosPorCasa(Casa casa) {

    ArrayList<Pago> lista = new ArrayList<>();

    String sql =
        "SELECT id_pago, fecha, monto, observacion, anulado FROM pago WHERE id_casa = ? AND anulado = false ORDER BY fecha DESC";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, casa.getIdCasa());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Pago pago = new Pago();

            pago.setIdPago(rs.getInt("id_pago"));
            pago.setCasa(casa);
            pago.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            pago.setMonto(rs.getInt("monto"));
            pago.setObservacion(rs.getString("observacion"));
            pago.setAnulado(rs.getBoolean("anulado"));

            lista.add(pago);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al listar los pagos.");
    }

    return lista;
}
    
    
    
    
    public void anularPago(int idPago) {

    String sql = "UPDATE pago SET anulado = true WHERE id_pago = ?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idPago);

        ps.executeUpdate();

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, "Error al anular el pago.");
    }
}
    
    
}
