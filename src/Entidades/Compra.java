package Entidades;

import java.time.LocalDateTime;

public class Compra {

    private int idCompra;
    private Casa casa;
    private LocalDateTime fecha;
    private String numeroComprobante;
    private int total;
    private String observacion;
    private boolean anulado;

    public Compra() {
    }

    public Compra(int idCompra, Casa casa, LocalDateTime fecha, String numeroComprobante, int total, String observacion, boolean anulado) {
        this.idCompra = idCompra;
        this.casa = casa;
        this.fecha = fecha;
        this.numeroComprobante = numeroComprobante;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
}

    public Compra(Casa casa, LocalDateTime fecha, String numeroComprobante, int total, String observacion, boolean anulado) {
        this.casa = casa;
        this.fecha = fecha;
        this.numeroComprobante = numeroComprobante;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
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

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }
    
    
    
    
    
}
