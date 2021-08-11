package model;

public class User {
    private int estado;
    private int id;
    private String nombre;

    public int getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
