package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "factura_id", nullable = false)
    private Integer facturaId;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    public Ventas() {}

    public Ventas(Integer facturaId, LocalDateTime fechaVenta, Integer usuarioId, BigDecimal montoTotal) {
        this.facturaId = facturaId;
        this.fechaVenta = fechaVenta;
        this.usuarioId = usuarioId;
        this.montoTotal = montoTotal;
    }

    public Integer getId() { return id; }
    public Integer getFacturaId() { return facturaId; }
    public void setFacturaId(Integer facturaId) { this.facturaId = facturaId; }
    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    @Override
    public String toString() {
        return String.format("Venta[id=%d, facturaId=%d, fechaVenta=%s, montoTotal=%s]", id, facturaId, fechaVenta, montoTotal);
    }
}
