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

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "producto_id", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "lote_id", insertable = false, updatable = false)
    private LoteProducto lote;

    @ManyToOne
    @JoinColumn(name = "bodega_id", insertable = false, updatable = false)
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public MovimientosInventario() {}

    public MovimientosInventario(Producto producto, LoteProducto lote, Bodega bodega, String tipoMovimiento,
                                 String moduloReferencia, Integer idReferencia, BigDecimal cantidad, Usuario usuario) {
        this.producto = producto;
        this.lote = lote;
        this.bodega = bodega;
        this.tipoMovimiento = tipoMovimiento;
        this.moduloReferencia = moduloReferencia;
        this.idReferencia = idReferencia;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.fechaMovimiento = LocalDateTime.now();
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

    public LoteProducto getLote() {
        return lote;
    }

    public void setLote(LoteProducto lote) {
        this.lote = lote;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getModuloReferencia() {
        return moduloReferencia;
    }

    public void setModuloReferencia(String moduloReferencia) {
        this.moduloReferencia = moduloReferencia;
    }

    public Integer getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format(
                "MovimientoInventario[id=%d, producto=%s, tipo='%s', cantidad=%s]",
                id, producto, tipoMovimiento, cantidad
        );
    }
}
