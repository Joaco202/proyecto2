package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "listas_precios")
public class ListasPrecios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_vigencia", nullable = false)
    private LocalDate fechaVigencia;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public ListasPrecios() {}

    public ListasPrecios(String nombre, LocalDate fechaVigencia) {
        this.nombre = nombre;
        this.fechaVigencia = fechaVigencia;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return String.format("ListaPrecio[id=%d, nombre='%s', fechaVigencia=%s]", id, nombre, fechaVigencia);
    }
}
