package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_compra", nullable = false, unique = true)
    private String numeroCompra;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Compras() {}

    public Compras(String numeroCompra, LocalDate fecha, String proveedor, BigDecimal montoTotal, String estado) {
        this.numeroCompra = numeroCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getNumeroCompra() { return numeroCompra; }
    public void setNumeroCompra(String numeroCompra) { this.numeroCompra = numeroCompra; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return String.format("Compra[id=%d, numeroCompra='%s', fecha=%s]", id, numeroCompra, fecha);
    }
}

