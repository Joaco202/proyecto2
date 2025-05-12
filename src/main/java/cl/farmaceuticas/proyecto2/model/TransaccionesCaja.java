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

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDateTime fechaTransaccion;

    /*@ManyToOne
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;*/

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public TransaccionesCaja() {
    }

    public TransaccionesCaja(/*Caja caja,*/ String tipo, BigDecimal monto, String descripcion,
            LocalDateTime fechaTransaccion, Usuario usuario) {
        //*this.caja = caja;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaTransaccion = fechaTransaccion;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    /*public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }*/

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("TransaccionCaja[id=%d, /*cajaId=%d, tipo='%s', monto=%s]", id, /*caja,*/ tipo, monto);
    }
}
