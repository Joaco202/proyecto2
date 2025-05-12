package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones_caja")
public class TransaccionesCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "caja_id", nullable = false)
    private Integer cajaId;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDateTime fechaTransaccion;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false/*nullable = false*/)
    private Usuario usuario;

    public TransaccionesCaja() {
    }

    public TransaccionesCaja(Integer cajaId, String tipo, BigDecimal monto, String descripcion,
            LocalDateTime fechaTransaccion, Integer usuarioId) {
        this.cajaId = cajaId;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaTransaccion = fechaTransaccion;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("TransaccionCaja[id=%d, cajaId=%d, tipo='%s', monto=%s]", id, cajaId, tipo, monto);
    }
}
