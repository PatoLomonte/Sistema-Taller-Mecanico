package Entidades;

import java.time.LocalDateTime;

public class VentaProducto {

    private int idVenta;
    private LocalDateTime fecha;
    private int total;
    private String observacion;
    private boolean anulado;

    public VentaProducto() {
    }

    public VentaProducto(int idVenta, LocalDateTime fecha, int total, String observacion, boolean anulado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public VentaProducto(LocalDateTime fecha, int total, String observacion, boolean anulado) {
        this.fecha = fecha;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }
}
