package Entidades;

public class Casa {

    private int idCasa;
    private String nombre;
    private String telefono;
    private String direccion;
    private String observacion;
    private int saldo;
    private boolean inactivo;

    public Casa() {
    }

    public Casa(int idCasa, String nombre, String telefono, String direccion, String observacion, int saldo, boolean inactivo) {
        this.idCasa = idCasa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.observacion = observacion;
        this.saldo = saldo;
        this.inactivo = inactivo;
    }

    public Casa(String nombre, String telefono, String direccion, String observacion, int saldo, boolean inactivo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.observacion = observacion;
        this.saldo = saldo;
        this.inactivo = inactivo;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean getInactivo() {
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
