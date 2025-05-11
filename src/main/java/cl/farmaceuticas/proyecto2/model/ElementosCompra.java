package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "elementos_compra")
public class ElementosCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compras compra;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private LoteProducto lote;

    @Column(nullable = false)
    private BigDecimal cantidad;

    @Column(nullable = false)
    private BigDecimal precio;

    public ElementosCompra() {}

    public ElementosCompra(Compras compra, Producto producto, LoteProducto lote, BigDecimal cantidad, BigDecimal precio) {
        this.compra = compra;
        this.producto = producto;
        this.lote = lote;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() { return id; }
    public Compras getCompra() { return compra; }
    public void setCompra(Compras compra) { this.compra = compra; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public LoteProducto getLote() { return lote; }
    public void setLote(LoteProducto lote) { this.lote = lote; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format("ElementoCompra[id=%d, compra=%s, producto=%s, cantidad=%s, precio=%s]",
                id,
                compra != null ? compra.getId() : "null",
                producto != null ? producto.getId() : "null",
                cantidad,
                precio);
    }
}


