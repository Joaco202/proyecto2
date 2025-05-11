package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "notas_credito")
public class NotasCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_nota_credito", nullable = false, unique = true)
    private String numeroNotaCredito;

    @Column(name = "compra_id", nullable = false)
    private Integer compraId;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public NotasCredito() {}

    public NotasCredito(String numeroNotaCredito, Integer compraId, LocalDate fecha, BigDecimal monto, String motivo) {
        this.numeroNotaCredito = numeroNotaCredito;
        this.compraId = compraId;
        this.fecha = fecha;
        this.monto = monto;
        this.motivo = motivo;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroNotaCredito() {
        return numeroNotaCredito;
    }

    public void setNumeroNotaCredito(String numeroNotaCredito) {
        this.numeroNotaCredito = numeroNotaCredito;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return String.format("NotaCredito[id=%d, numeroNotaCredito='%s', fecha=%s]", id, numeroNotaCredito, fecha);
    }
}
