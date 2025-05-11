package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;




@Entity
@Table(name = "fraccionamientos")
public class Fraccionamientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto_original_id", nullable = false)
    private Producto productoOriginal;

    @ManyToOne
    @JoinColumn(name = "producto_fraccion_id", nullable = false)
    private Producto productoFraccion;

    @Column(nullable = false)
    private BigDecimal cantidad;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Fraccionamientos() {}

    public Fraccionamientos(Producto productoOriginal, Producto productoFraccion, BigDecimal cantidad, LocalDateTime fecha, Usuario usuario) {
        this.productoOriginal = productoOriginal;
        this.productoFraccion = productoFraccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getId() { return id; }

    public Producto getProductoOriginal() { return productoOriginal; }
    public void setProductoOriginal(Producto productoOriginal) { this.productoOriginal = productoOriginal; }

    public Producto getProductoFraccion() { return productoFraccion; }
    public void setProductoFraccion(Producto productoFraccion) { this.productoFraccion = productoFraccion; }

    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return String.format("Fraccionamiento[id=%d, originalId=%d, fraccionId=%d, cantidad=%s]",
                id,
                productoOriginal != null ? productoOriginal.getId() : null,
                productoFraccion != null ? productoFraccion.getId() : null,
                cantidad);
    }
}

