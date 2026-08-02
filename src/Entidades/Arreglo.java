package Entidades;

import java.time.LocalDateTime;

public class Arreglo {

    private int idArreglo;
    private Auto auto;
    private LocalDateTime fecha;
    private int kilometros;
    private int total;
    private String observacion;
    private boolean anulado;

    public Arreglo() {
    }

    public Arreglo(int idArreglo, Auto auto, LocalDateTime fecha, int kilometros, int total, String observacion, boolean anulado) {
        this.idArreglo = idArreglo;
        this.auto = auto;
        this.fecha = fecha;
        this.kilometros = kilometros;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public Arreglo(Auto auto, LocalDateTime fecha, int kilometros, int total, String observacion, boolean anulado) {
        this.auto = auto;
        this.fecha = fecha;
        this.kilometros = kilometros;
        this.total = total;
        this.observacion = observacion;
        this.anulado = anulado;
    }

    public int getIdArreglo() {
        return idArreglo;
    }

    public void setIdArreglo(int idArreglo) {
        this.idArreglo = idArreglo;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
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
