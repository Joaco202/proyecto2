package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "elementos_venta")
public class ElementosVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "venta_id", nullable = false)
    private Integer ventaId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "lote_id")
    private Integer loteId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;

    @ManyToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega bodega;

    public ElementosVenta() {}

    public ElementosVenta(Integer ventaId, Integer productoId, Integer loteId, BigDecimal cantidad, BigDecimal precio, BigDecimal descuento, Bodega bodega) {
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.loteId = loteId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.bodega = bodega;
    }

    public Integer getId() { return id; }

    public Integer getVentaId() { return ventaId; }
    public void setVentaId(Integer ventaId) { this.ventaId = ventaId; }

    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }

    public Integer getLoteId() { return loteId; }
    public void setLoteId(Integer loteId) { this.loteId = loteId; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public BigDecimal getDescuento() { return descuento; }
    public void setDescuento(BigDecimal descuento) { this.descuento = descuento; }

    public Bodega getBodega() { return bodega; }
    public void setBodega(Bodega bodega) { this.bodega = bodega; }

    @Override
    public String toString() {
        return String.format("ElementoVenta[id=%d, ventaId=%d, productoId=%d, cantidad=%s, precio=%s, descuento=%s, bodega=%s]",
                id, ventaId, productoId, cantidad, precio, descuento, bodega != null ? bodega.getId() : "null");
    }
}
