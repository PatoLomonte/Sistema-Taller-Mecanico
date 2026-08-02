package AccesoDatos;

import Entidades.DetalleVentaProducto;
import Entidades.Producto;
import Entidades.VentaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentaProductoData {

    private Connection con = null;
    private ProductoData productoData = new ProductoData();

    public VentaProductoData() {
        con = Conexion.getConexion();
    }

    public int guardarVentaProducto(VentaProducto venta) {

        int idVenta = -1;

        String sql = "INSERT INTO venta_producto "
                + "(fecha, total, observacion, anulado) "
                + "VALUES (?, ?, ?, false)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, Timestamp.valueOf(venta.getFecha()));
            ps.setInt(2, venta.getTotal());
            ps.setString(3, venta.getObservacion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idVenta = rs.getInt(1);
                venta.setIdVenta(idVenta);
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar venta: " + ex.getMessage());
            ex.printStackTrace();
        }

        return idVenta;
    }

    public void guardarDetalleVentaProducto(DetalleVentaProducto detalle) {

        String sql = "INSERT INTO detalle_venta_producto "
                + "(id_venta, id_producto, cantidad, precio_unitario, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, detalle.getVentaProducto().getIdVenta());
            ps.setInt(2, detalle.getProducto().getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setInt(4, detalle.getPrecioUnitario());
            ps.setInt(5, detalle.getSubtotal());

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public ArrayList<VentaProducto> listarVentasProducto() {

        ArrayList<VentaProducto> ventas = new ArrayList<>();

        String sql = "SELECT * FROM venta_producto "
                + "WHERE anulado = false "
                + "ORDER BY fecha DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                VentaProducto venta = new VentaProducto();

                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                venta.setTotal(rs.getInt("total"));
                venta.setObservacion(rs.getString("observacion"));
                venta.setAnulado(rs.getBoolean("anulado"));

                ventas.add(venta);
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al listar ventas: " + ex.getMessage());
            ex.printStackTrace();
        }

        return ventas;
    }

    public ArrayList<VentaProducto> listarVentasProductoFiltro(int mes, int anio) {

        ArrayList<VentaProducto> ventas = new ArrayList<>();

        String sql = "SELECT * FROM venta_producto "
                + "WHERE anulado = false ";

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
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                VentaProducto venta = new VentaProducto();

                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                venta.setTotal(rs.getInt("total"));
                venta.setObservacion(rs.getString("observacion"));
                venta.setAnulado(rs.getBoolean("anulado"));

                ventas.add(venta);
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al listar ventas filtradas: " + ex.getMessage());
            ex.printStackTrace();
        }

        return ventas;
    }

    public VentaProducto buscarVentaProductoPorId(int idVenta) {

        VentaProducto venta = null;

        String sql = "SELECT * FROM venta_producto "
                + "WHERE id_venta = ? AND anulado = false";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idVenta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                venta = new VentaProducto();

                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                venta.setTotal(rs.getInt("total"));
                venta.setObservacion(rs.getString("observacion"));
                venta.setAnulado(rs.getBoolean("anulado"));
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar venta: " + ex.getMessage());
            ex.printStackTrace();
        }

        return venta;
    }

    
    
    
    
    public ArrayList<DetalleVentaProducto> obtenerDetalleVentaProducto(int idVenta) {

            ArrayList<DetalleVentaProducto> detalles = new ArrayList<>();

            String sql = "SELECT d.id_detalle, d.id_venta, d.id_producto, "
                    + "d.cantidad, d.precio_unitario, d.subtotal, "
                    + "p.codigo_barra, p.nombre, p.precio, p.stock, p.inactivo "
                    + "FROM detalle_venta_producto d "
                    + "JOIN producto p ON d.id_producto = p.id_producto "
                    + "WHERE d.id_venta = ?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, idVenta);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    VentaProducto venta = new VentaProducto();
                    venta.setIdVenta(idVenta);

                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setCodigoBarra(rs.getString("codigo_barra"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getInt("precio"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setInactivo(rs.getBoolean("inactivo"));

                    DetalleVentaProducto detalle = new DetalleVentaProducto();

                    detalle.setIdDetalle(rs.getInt("id_detalle"));
                    detalle.setVentaProducto(venta);
                    detalle.setProducto(producto);
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setPrecioUnitario(rs.getInt("precio_unitario"));
                    detalle.setSubtotal(rs.getInt("subtotal"));

                    detalles.add(detalle);
                }

                ps.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener detalle de venta: " + ex.getMessage());
                ex.printStackTrace();
            }

            return detalles;
}

    
    
    
    
    
    public void anularVentaProducto(int idVenta) {

        String sql = "UPDATE venta_producto SET anulado = true "
                + "WHERE id_venta = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idVenta);

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al anular venta: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void devolverStockDeVenta(int idVenta) {

        ArrayList<DetalleVentaProducto> detalles = obtenerDetalleVentaProducto(idVenta);

        for (DetalleVentaProducto detalle : detalles) {
            if (detalle.getProducto() != null) {
                productoData.sumarStock(
                        detalle.getProducto().getIdProducto(),
                        detalle.getCantidad()
                );
            }
        }
    }
    
    
}
