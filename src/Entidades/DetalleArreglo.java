package Entidades;

public class DetalleArreglo {

    private int idDetalle;
    private Arreglo arreglo;
    private String descripcion;
    private int importe;

    public DetalleArreglo() {
    }

    public DetalleArreglo(int idDetalle, Arreglo arreglo, String descripcion, int importe) {
        this.idDetalle = idDetalle;
        this.arreglo = arreglo;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public DetalleArreglo(Arreglo arreglo, String descripcion, int importe) {
        this.arreglo = arreglo;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Arreglo getArreglo() {
        return arreglo;
    }

    public void setArreglo(Arreglo arreglo) {
        this.arreglo = arreglo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
}
