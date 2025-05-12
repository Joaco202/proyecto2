package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entidad Regla de Alerta para productos
 */
@Entity
@Table(name = "reglas_alerta")
public class ReglasAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "intervalo_dias")
    private Integer intervaloDias;

    @Column(name = "umbral_cantidad")
    private BigDecimal umbralCantidad;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public ReglasAlerta() {}

    public ReglasAlerta(Producto producto, Integer intervaloDias, BigDecimal umbralCantidad, Boolean activo) {
        this.producto = producto;
        this.intervaloDias = intervaloDias;
        this.umbralCantidad = umbralCantidad;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getIntervaloDias() {
        return intervaloDias;
    }

    public void setIntervaloDias(Integer intervaloDias) {
        this.intervaloDias = intervaloDias;
    }

    public BigDecimal getUmbralCantidad() {
        return umbralCantidad;
    }

    public void setUmbralCantidad(BigDecimal umbralCantidad) {
        this.umbralCantidad = umbralCantidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return String.format("ReglaAlerta[id=%d, producto=%s, intervaloDias=%d, umbralCantidad=%s, activo=%s]", id, producto, intervaloDias, umbralCantidad, activo);
    }
}
