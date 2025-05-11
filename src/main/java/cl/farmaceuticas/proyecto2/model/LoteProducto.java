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

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "numero_lote")
    private String numeroLote;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "bodega_id", nullable = false)
    private Bodega bodega;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public LoteProducto() {}

    public LoteProducto(Producto producto, String numeroLote, LocalDate fechaVencimiento, Bodega bodega, BigDecimal cantidad) {
        this.producto = producto;
        this.numeroLote = numeroLote;
        this.fechaVencimiento = fechaVencimiento;
        this.bodega = bodega;
        this.cantidad = cantidad;
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

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return String.format(
                "LoteProducto[id=%d, productoId=%d, bodegaId=%d, lote='%s']",
                id,
                producto != null ? producto.getId() : null,
                bodega != null ? bodega.getId() : null,
                numeroLote
        );
    }
}
