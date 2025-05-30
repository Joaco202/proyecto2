package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cajas")
public class Cajas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "monto_inicial")
    private BigDecimal montoInicial;

    @Column(name = "monto_final")
    private BigDecimal montoFinal;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Cajas() {
    }

    public Cajas(LocalDate fechaRegistro, BigDecimal montoInicial, BigDecimal montoFinal, Usuario usuario) {
        this.fechaRegistro = fechaRegistro;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public BigDecimal getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(BigDecimal montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("Caja[id=%d, fechaRegistro=%s, montoInicial=%s, montoFinal=%s]", id, fechaRegistro,
                montoInicial, montoFinal);
    }
}
