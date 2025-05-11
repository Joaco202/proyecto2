package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "lotes_producto")
public class LoteProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "numero_lote")
    private String numeroLote;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "bodega_id", nullable = false)
    private Integer bodegaId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public LoteProducto() {}

    public LoteProducto(Integer productoId, String numeroLote, LocalDate fechaVencimiento, Integer bodegaId, BigDecimal cantidad) {
        this.productoId = productoId;
        this.numeroLote = numeroLote;
        this.fechaVencimiento = fechaVencimiento;
        this.bodegaId = bodegaId;
        this.cantidad = cantidad;
    }

    public Integer getId() { return id; }
    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }
    public String getNumeroLote() { return numeroLote; }
    public void setNumeroLote(String numeroLote) { this.numeroLote = numeroLote; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public Integer getBodegaId() { return bodegaId; }
    public void setBodegaId(Integer bodegaId) { this.bodegaId = bodegaId; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return String.format("LoteProducto[id=%d, productoId=%d, lote='%s']", id, productoId, numeroLote);
    }
}
