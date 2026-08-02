package Entidades;

public class Producto {

    private int idProducto;
    private String codigoBarra;
    private String nombre;
    private int precio;
    private int stock;
    private String categoria;
    private boolean inactivo;

    public Producto() {
    }

    public Producto(int idProducto, String codigoBarra, String nombre, int precio, int stock, String categoria, boolean inactivo) {
        this.idProducto = idProducto;
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.inactivo = inactivo;
    }

    public Producto(String codigoBarra, String nombre, int precio, int stock, String categoria, boolean inactivo) {
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.inactivo = inactivo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    

    public boolean isInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
