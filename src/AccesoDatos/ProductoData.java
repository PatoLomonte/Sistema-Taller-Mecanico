package AccesoDatos;

import Entidades.DetalleVentaProducto;
import Entidades.Producto;
import Entidades.VentaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    
    
    public void guardarProducto(Producto producto) {

        String sql = "INSERT INTO producto "
                + "(codigo_barra, nombre, precio, stock, inactivo, categoria) "
                + "VALUES (?, ?, ?, ?, false, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, producto.getCodigoBarra());
            ps.setString(2, producto.getNombre());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getCategoria());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto guardado correctamente.");
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto: " + ex.getMessage());
            ex.printStackTrace();
        }
}
    
    
    
    
    

    public ArrayList<Producto> listarProductos(String categoria) {

    ArrayList<Producto> productos = new ArrayList<>();

    String sql;

    if (categoria.equals("Todas")) {

        sql = "SELECT * FROM producto "
                + "WHERE inactivo = false "
                + "ORDER BY nombre";

    } else {

        sql = "SELECT * FROM producto "
                + "WHERE categoria = ? "
                + "AND inactivo = false "
                + "ORDER BY nombre";
    }

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        if (!categoria.equals("Todas")) {

            ps.setString(1, categoria);

        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Producto producto = new Producto();

            producto.setIdProducto(rs.getInt("id_producto"));
            producto.setCodigoBarra(rs.getString("codigo_barra"));
            producto.setNombre(rs.getString("nombre"));
            producto.setCategoria(rs.getString("categoria"));
            producto.setPrecio(rs.getInt("precio"));
            producto.setStock(rs.getInt("stock"));
            producto.setInactivo(rs.getBoolean("inactivo"));

            productos.add(producto);
        }

        ps.close();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,
                "Error al listar productos.\n" + ex.getMessage());
    }

    return productos;
}
    
    
    
    
    

    public Producto buscarProductoPorId(int idProducto) {

        Producto producto = null;

        String sql = "SELECT * FROM producto "
                + "WHERE id_producto = ? AND inactivo = false";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setCodigoBarra(rs.getString("codigo_barra"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setInactivo(rs.getBoolean("inactivo"));
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar producto: " + ex.getMessage());
            ex.printStackTrace();
        }

        return producto;
    }

    
    
    
    public Producto buscarProductoPorCodigoBarra(String codigoBarra) {

        Producto producto = null;

        String sql = "SELECT * FROM producto "
                + "WHERE codigo_barra = ? AND inactivo = false";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codigoBarra);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setCodigoBarra(rs.getString("codigo_barra"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setInactivo(rs.getBoolean("inactivo"));
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar producto por código: " + ex.getMessage());
            ex.printStackTrace();
        }

        return producto;
}
    
    
    
    
    

    public ArrayList<Producto> buscarProductosPorNombreOCodigo(String texto) {

        ArrayList<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM producto "
                + "WHERE inactivo = false "
                + "AND (nombre LIKE ? OR codigo_barra LIKE ?) "
                + "ORDER BY nombre";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setCodigoBarra(rs.getString("codigo_barra"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setInactivo(rs.getBoolean("inactivo"));

                productos.add(producto);
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos: " + ex.getMessage());
            ex.printStackTrace();
        }

        return productos;
    }

    public void modificarProducto(Producto producto) {

        String sql = "UPDATE producto SET "
                + "codigo_barra = ?, "
                + "nombre = ?, "
                + "precio = ? "
                + "WHERE id_producto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getCodigoBarra());
            ps.setString(2, producto.getNombre());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getIdProducto());

            int filas = ps.executeUpdate();

            if (filas == 1) {
                System.out.println("Producto modificado correctamente.");
            }

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void sumarStock(int idProducto, int cantidad) {

        String sql = "UPDATE producto SET stock = stock + ? "
                + "WHERE id_producto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al sumar stock: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    public void descontarStock(int idProducto, int cantidad) {

        String sql = "UPDATE producto SET stock = stock - ? "
                + "WHERE id_producto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al descontar stock: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void ajustarStock(int idProducto, int nuevoStock) {

        String sql = "UPDATE producto SET stock = ? "
                + "WHERE id_producto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al ajustar stock: " + ex.getMessage());
            ex.printStackTrace();
        }
}

    public void darDeBajaProducto(int idProducto) {

        String sql = "UPDATE producto SET inactivo = true WHERE id_producto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idProducto);

            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja producto: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    
    
    public int actualizarPrecioCategoria(String categoria, double porcentaje, boolean aumentar) {

        String operador = aumentar ? "+" : "-";

        String sql = "UPDATE producto "
                + "SET precio = ROUND((precio "
                + operador
                + " (precio * ? / 100)) / 100, 0) * 100 "
                + "WHERE categoria = ? "
                + "AND inactivo = false";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, porcentaje);
            ps.setString(2, categoria);

            int filas = ps.executeUpdate();

            ps.close();

            return filas;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null,
                    "Error al actualizar precios.\n" + ex.getMessage());

        }

        return 0;
}
    
    
    
    
    
}






