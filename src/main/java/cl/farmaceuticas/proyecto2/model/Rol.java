package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class Rol {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", updatable = false, nullable = false)
    private Long idRol;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    public Rol() {
    }

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
