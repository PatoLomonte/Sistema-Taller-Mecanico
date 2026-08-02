package Entidades;

import java.time.LocalDateTime;

public class Gasto {

    private int idGasto;
    private LocalDateTime fecha;
    private String categoria;
    private String descripcion;
    private int monto;
    private String observacion;
    private boolean anulado;

    public Gasto() {
    }

    public Gasto(int idGasto, LocalDateTime fecha, String categoria, String descripcion, int monto, String observacion, boolean anulado) {
        this.idGasto = idGasto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.monto = monto;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public Gasto(LocalDateTime fecha, String categoria, String descripcion, int monto, String observacion, boolean anulado) {
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.monto = monto;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
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
