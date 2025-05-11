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
    private Integer id;

    @Column(name = "numero_nota_credito", nullable = false, unique = true)
    private String numeroNotaCredito;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compras compra;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public NotasCredito() {}

    public NotasCredito(String numeroNotaCredito, Compras compra, LocalDate fecha, BigDecimal monto, String motivo) {
        this.numeroNotaCredito = numeroNotaCredito;
        this.compra = compra;
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

    public Compras getCompra() {
        return compra;
    }

    public void setCompra(Compras compra) {
        this.compra = compra;
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

