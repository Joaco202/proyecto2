package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Registro de dispensaciones de productos a beneficiarios
 */
@Entity
@Table(name = "dispensaciones")
public class Dispensaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "beneficiario_id", nullable = false)
    private Integer beneficiarioId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "lote_id")
    private Integer loteId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    public Dispensaciones() {}

    public Dispensaciones(Integer beneficiarioId, Integer productoId, Integer loteId, BigDecimal cantidad, LocalDateTime fecha, Integer usuarioId) {
        this.beneficiarioId = beneficiarioId;
        this.productoId = productoId;
        this.loteId = loteId;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public Integer getId() { return id; }
    public Integer getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Integer beneficiarioId) { this.beneficiarioId = beneficiarioId; }
    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }
    public Integer getLoteId() { return loteId; }
    public void setLoteId(Integer loteId) { this.loteId = loteId; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return String.format("Dispensacion[id=%d, beneficiarioId=%d, productoId=%d, cantidad=%s]", id, beneficiarioId, productoId, cantidad);
    }
}
