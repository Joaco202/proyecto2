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

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Dispensaciones() {}

    public Dispensaciones(BigDecimal cantidad, LocalDateTime fecha, /*Beneficiarios beneficiarios, Producto producto,
                            LotesProducto lotesProducto, */Usuario usuario) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        /*this.beneficiarios = beneficiarios;
        this.producto = producto;
        this.lotesProducto = lotesProducto;*/
        this.usuario = usuario;
    }

    public Integer getId() { return id; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    /*public Beneficiarios getBeneficiarios() { return beneficiarios; }
    public void setBeneficiarios(Beneficiarios beneficiarios) { this.beneficiarios = beneficiarios; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public LotesProducto getLotesProducto() { return lotesProducto; }
    public void setLotesProducto(LotesProducto lotesProducto) { this.lotesProducto = lotesProducto; }*/
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return String.format("Dispensacion[id=%d, cantidad=%s]", id, cantidad);
    }
}
