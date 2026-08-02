package Entidades;

public class DetalleVentaProducto {

    private int idDetalle;
    private VentaProducto ventaProducto;
    private Producto producto;
    private int cantidad;
    private int precioUnitario;
    private int subtotal;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(int idDetalle, VentaProducto ventaProducto, Producto producto, int cantidad, int precioUnitario, int subtotal) {
        this.idDetalle = idDetalle;
        this.ventaProducto = ventaProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public DetalleVentaProducto(VentaProducto ventaProducto, Producto producto, int cantidad, int precioUnitario, int subtotal) {
        this.ventaProducto = ventaProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public VentaProducto getVentaProducto() {
        return ventaProducto;
    }

    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
