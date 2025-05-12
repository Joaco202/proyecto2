package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "elementos_venta")
public class ElementosVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;

    @ManyToOne
    @JoinColumn(name = "lote_id", referencedColumnName = "id")
    private LoteProducto lote;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;


    public ElementosVenta() {}

    public ElementosVenta(Ventas venta, Producto producto, BigDecimal cantidad,
                          BigDecimal precio, BigDecimal descuento, LoteProducto lote) {
        this.venta = venta;
        this.producto = producto;
        this.lote = lote;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Integer getId() { return id; }

    public Ventas getVenta() { return venta; }
    public void setVenta(Ventas venta) { this.venta = venta; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public LoteProducto getLote() { return lote; }
    public void setLote(LoteProducto lote) { this.lote = lote; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public BigDecimal getDescuento() { return descuento; }
    public void setDescuento(BigDecimal descuento) { this.descuento = descuento; }

    @Override
    public String toString() {
        return String.format("ElementoVenta[id=%d, ventaId=%d, productoId=%d, cantidad=%s, precio=%s, descuento=%s, lote=%s]",
                id,
                venta != null ? venta.getId() : null,
                producto != null ? producto.getId() : null,
                cantidad, precio, descuento,
                lote != null ? lote.getId() : "null");
    }
}

