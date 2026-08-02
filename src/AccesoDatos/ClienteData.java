package AccesoDatos;

import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteData {

    private Connection con = null;

    public ClienteData() {
        con = Conexion.getConexion();
    }

    public int guardarCliente(Cliente cliente) {

        int idGenerado = -1;

        String sql = "INSERT INTO cliente(nombre, telefono, direccion, observacion, inactivo) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getObservacion());
            ps.setBoolean(5, false);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idGenerado = rs.getInt(1);
                cliente.setIdCliente(idGenerado);
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar el cliente.");
            System.out.println("Error guardarCliente: " + ex.getMessage());
        }

        return idGenerado;
    }

    public Cliente buscarClientePorId(int idCliente) {

        Cliente cliente = null;

        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setObservacion(rs.getString("observacion"));
                cliente.setInactivo(rs.getBoolean("inactivo"));
            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al buscar el cliente.");
            System.out.println("Error buscarClientePorId: " + ex.getMessage());
        }

        return cliente;
    }
}
