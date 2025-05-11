package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "facturas")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_factura", nullable = false, unique = true)
    private String numeroFactura;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "beneficiario_id", nullable = false)
    private Integer beneficiarioId;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Facturas() {}

    public Facturas(String numeroFactura, LocalDate fecha, Integer beneficiarioId, BigDecimal montoTotal, String estado) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.beneficiarioId = beneficiarioId;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Integer getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Integer beneficiarioId) { this.beneficiarioId = beneficiarioId; }
    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return String.format("Factura[id=%d, numeroFactura='%s', fecha=%s]", id, numeroFactura, fecha);
    }
}
