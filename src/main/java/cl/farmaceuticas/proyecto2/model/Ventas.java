package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", nullable = false)
    private Facturas factura;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    public Ventas() {}

    public Ventas(Facturas factura, LocalDateTime fechaVenta, Integer usuarioId, BigDecimal montoTotal) {
        this.factura = factura;
        this.fechaVenta = fechaVenta;
        this.usuarioId = usuarioId;
        this.montoTotal = montoTotal;
    }

    public Integer getId() { return id; }

    public Facturas getFactura() { return factura; }
    public void setFactura(Facturas factura) { this.factura = factura; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public Usuario getUsuario() { return usuario; }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    @Override
    public String toString() {
        return String.format(
                "Venta[id=%d, facturaId=%d, usuarioId=%d, fechaVenta=%s, montoTotal=%s]",
                id,
                factura != null ? factura.getId() : null,
                usuarioId,
                fechaVenta,
                montoTotal
        );
    }
}
