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

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Dispersiones() {
    }

    public Dispersiones(BigDecimal monto, LocalDateTime fecha, String estado, /*Beneficiarios beneficiarios, */Usuario usuario) {
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        //this.beneficiarios = beneficiarios;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    /*public void setBeneficiarios(Beneficiarios beneficiarios) {
        //this.beneficiarios = beneficiarios;
    }*/

    /*public Beneficiarios getBeneficiarios() {
        return beneficiarios;
    }*/

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("Dispersion[id=%d, monto=%s, estado='%s', usuario=%s]", id, monto, estado, usuario);
    }
}
