package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "fraccionamientos")
public class Fraccionamientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "producto_original_id", nullable = false)
    private Integer productoOriginalId;

    @Column(name = "producto_fraccion_id", nullable = false)
    private Integer productoFraccionId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    public Fraccionamientos() {}

    public Fraccionamientos(Integer productoOriginalId, Integer productoFraccionId, BigDecimal cantidad, LocalDateTime fecha, Integer usuarioId) {
        this.productoOriginalId = productoOriginalId;
        this.productoFraccionId = productoFraccionId;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public Integer getId() { return id; }
    public Integer getProductoOriginalId() { return productoOriginalId; }
    public void setProductoOriginalId(Integer productoOriginalId) { this.productoOriginalId = productoOriginalId; }
    public Integer getProductoFraccionId() { return productoFraccionId; }
    public void setProductoFraccionId(Integer productoFraccionId) { this.productoFraccionId = productoFraccionId; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return String.format("Fraccionamiento[id=%d, originalId=%d, fraccionId=%d, cantidad=%s]", id, productoOriginalId, productoFraccionId, cantidad);
    }
}

