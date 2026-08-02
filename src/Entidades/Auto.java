package Entidades;

public class Auto {

    private int idAuto;
    private Cliente cliente;
    private String vehiculo;
    private String patente;
    private int kilometros;
    private String observacion;
    private boolean inactivo;

    public Auto() {
    }

    public Auto(int idAuto, Cliente cliente, String vehiculo, String patente, int kilometros, String observacion, boolean inactivo) {
        this.idAuto = idAuto;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.kilometros = kilometros;
        this.observacion = observacion;
        this.inactivo = inactivo;
    }

    public Auto(Cliente cliente, String vehiculo, String patente, int kilometros, String observacion, boolean inactivo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.kilometros = kilometros;
        this.observacion = observacion;
        this.inactivo = inactivo;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
    }

    @Override
    public String toString() {
        return patente + " - " + vehiculo;
    }
}
