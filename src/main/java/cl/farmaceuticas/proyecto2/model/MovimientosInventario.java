package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_inventario")
public class MovimientosInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "lote_id")
    private Integer loteId;

    @Column(name = "bodega_id", nullable = false)
    private Integer bodegaId;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipoMovimiento;

    @Column(name = "modulo_referencia")
    private String moduloReferencia;

    @Column(name = "id_referencia")
    private Integer idReferencia;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDateTime fechaMovimiento;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    public MovimientosInventario() {}

    public MovimientosInventario(Integer productoId, Integer loteId, Integer bodegaId, String tipoMovimiento, String moduloReferencia, Integer idReferencia, BigDecimal cantidad, Integer usuarioId) {
        this.productoId = productoId;
        this.loteId = loteId;
        this.bodegaId = bodegaId;
        this.tipoMovimiento = tipoMovimiento;
        this.moduloReferencia = moduloReferencia;
        this.idReferencia = idReferencia;
        this.cantidad = cantidad;
        this.usuarioId = usuarioId;
    }

    public Integer getId() { return id; }
    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }
    public Integer getLoteId() { return loteId; }
    public void setLoteId(Integer loteId) { this.loteId = loteId; }
    public Integer getBodegaId() { return bodegaId; }
    public void setBodegaId(Integer bodegaId) { this.bodegaId = bodegaId; }
    public String getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(String tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }
    public String getModuloReferencia() { return moduloReferencia; }
    public void setModuloReferencia(String moduloReferencia) { this.moduloReferencia = moduloReferencia; }
    public Integer getIdReferencia() { return idReferencia; }
    public void setIdReferencia(Integer idReferencia) { this.idReferencia = idReferencia; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFechaMovimiento() { return fechaMovimiento; }
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return String.format("MovimientoInventario[id=%d, productoId=%d, tipo='%s', cantidad=%s]", id, productoId, tipoMovimiento, cantidad);
    }
}
