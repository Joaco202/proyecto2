package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "elementos_compra")
public class ElementosCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "compra_id", nullable = false)
    private Integer compraId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "lote_id")
    private Integer loteId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    public ElementosCompra() {}

    public ElementosCompra(Integer compraId, Integer productoId, Integer loteId, BigDecimal cantidad, BigDecimal precio) {
        this.compraId = compraId;
        this.productoId = productoId;
        this.loteId = loteId;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() { return id; }
    public Integer getCompraId() { return compraId; }
    public void setCompraId(Integer compraId) { this.compraId = compraId; }
    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }
    public Integer getLoteId() { return loteId; }
    public void setLoteId(Integer loteId) { this.loteId = loteId; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format("ElementoCompra[id=%d, compraId=%d, productoId=%d, cantidad=%s, precio=%s]", id, compraId, productoId, cantidad, precio);
    }
}

