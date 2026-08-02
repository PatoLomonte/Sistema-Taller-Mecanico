package Entidades;

import java.time.LocalDateTime;


public class Pago {
 
    private int idPago;
    private Casa casa;
    private LocalDateTime fecha;
    private int monto;
    private String observacion;
    private boolean anulado;

    
    public Pago(int idPago, Casa casa, LocalDateTime fecha, int monto, String observacion, boolean anulado) {
        this.idPago = idPago;
        this.casa = casa;
        this.fecha = fecha;
        this.monto = monto;
        this.observacion = observacion;
        this.anulado = anulado;
}

    public Pago(Casa casa, LocalDateTime fecha, int monto, String observacion, boolean anulado) {
        this.casa = casa;
        this.fecha = fecha;
        this.monto = monto;
        this.observacion = observacion;
        this.anulado = anulado;
    }
    
    
    public Pago(){
        
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
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

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }
    
    

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", casa=" + casa + ", fecha=" + fecha + ", monto=" + monto + ", observacion=" + observacion + '}';
    }
    
       
    
}
