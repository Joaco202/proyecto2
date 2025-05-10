package cl.farmaceuticas.proyecto2.model;

public class Rol {
    private int id_rol;
    private String nombre_rol;
    private String descripcion_rol;

    public Rol(int id_rol, String nombre_rol, String descripcion_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.descripcion_rol = descripcion_rol;
    }

    public int getIdRol() {
        return id_rol;
    }

    public void setIdRol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombreRol() {
        return nombre_rol;
    }

    public void setNombreRol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcionRol() {
        return descripcion_rol;
    }

    public void setDescripcionRol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }
}
