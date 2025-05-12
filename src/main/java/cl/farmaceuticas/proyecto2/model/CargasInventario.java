package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cargas_inventario")
public class CargasInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "bodega_id", nullable = false)
    private Bodega bodega;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "tipo_carga", nullable = false)
    private String tipoCarga;

    @Column(name = "fecha_carga")
    private LocalDateTime fechaCarga;

    public CargasInventario() {}

    public CargasInventario(Producto producto, Bodega bodega, BigDecimal cantidad, String tipoCarga, Usuario usuario) {
        this.producto = producto;
        this.bodega = bodega;
        this.cantidad = cantidad;
        this.tipoCarga = tipoCarga;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public LocalDateTime getFechaCarga() {
        return fechaCarga;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format(
                "CargaInventario[id=%d, productoId=%d, bodegaId=%d, cantidad=%s, tipoCarga='%s']",
                id,
                producto != null ? producto.getId() : null,
                bodega != null ? bodega.getId() : null,
                cantidad,
                tipoCarga
        );
    }
}
