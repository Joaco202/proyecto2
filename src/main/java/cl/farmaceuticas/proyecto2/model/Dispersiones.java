package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Registro de dispersiones de fondos a beneficiarios
 */
@Entity
@Table(name = "dispersiones")
public class Dispersiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "beneficiario_id", nullable = false)
    private Integer beneficiarioId;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false/*nullable = false*/)
    private Usuario usuario;

    public Dispersiones() {
    }

    public Dispersiones(Integer beneficiarioId, BigDecimal monto, LocalDateTime fecha, Integer usuarioId,
            String estado) {
        this.beneficiarioId = beneficiarioId;
        this.monto = monto;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(Integer beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("Dispersion[id=%d, beneficiarioId=%d, monto=%s, estado='%s']", id, beneficiarioId, monto,
                estado);
    }
}
