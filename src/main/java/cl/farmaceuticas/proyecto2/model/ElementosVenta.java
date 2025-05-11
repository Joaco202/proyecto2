package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "elementos_venta")
public class ElementosVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "lote_id")
    private Integer loteId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega bodega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id", nullable = false)
    private Ventas venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;


    public ElementosVenta() {}

    public ElementosVenta(Ventas venta, Producto producto, Integer loteId, BigDecimal cantidad,
                          BigDecimal precio, BigDecimal descuento, Bodega bodega) {
        this.venta = venta;
        this.producto = producto;
        this.loteId = loteId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.bodega = bodega;
    }

    public Integer getId() { return id; }

    public Ventas getVenta() { return venta; }
    public void setVenta(Ventas venta) { this.venta = venta; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

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
                id,
                venta != null ? venta.getId() : null,
                producto != null ? producto.getId() : null,
                cantidad, precio, descuento,
                bodega != null ? bodega.getId() : "null");
    }
}

