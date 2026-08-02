package Entidades;

public class DetalleCompra {

    private int idDetalle;
    private Compra compra;
    private int cantidad;
    private String descripcion;
    private String codigo;
    private int precioUnitario;
    private int subtotal;

    public DetalleCompra() {
    }

    public DetalleCompra(Compra compra, int cantidad, String codigo, String descripcion, int precioUnitario, int subtotal) {
    this.compra = compra;
    this.cantidad = cantidad;
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.precioUnitario = precioUnitario;
    this.subtotal = subtotal;
}

   /* public DetalleCompra(Compra compra, String descripcion, int cantidad, String codigo, int precioUnitario, int subtotal) {
        this.compra = compra;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }*/

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
