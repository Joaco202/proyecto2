package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "cargas_inventario")
public class CargaInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "bodega_id", nullable = false)
    private Integer bodegaId;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "tipo_carga", nullable = false)
    private String tipoCarga;

    @Column(name = "fecha_carga")
    private LocalDateTime fechaCarga;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    public CargaInventario() {}

    public CargaInventario(Integer productoId, Integer bodegaId, BigDecimal cantidad, String tipoCarga, Integer usuarioId) {
        this.productoId = productoId;
        this.bodegaId = bodegaId;
        this.cantidad = cantidad;
        this.tipoCarga = tipoCarga;
        this.usuarioId = usuarioId;
    }

    public Integer getId() { return id; }
    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }
    public Integer getBodegaId() { return bodegaId; }
    public void setBodegaId(Integer bodegaId) { this.bodegaId = bodegaId; }
    public BigDecimal getCantidad() { return cantidad; }
    public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    public String getTipoCarga() { return tipoCarga; }
    public void setTipoCarga(String tipoCarga) { this.tipoCarga = tipoCarga; }
    public LocalDateTime getFechaCarga() { return fechaCarga; }
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return String.format(
                "CargaInventario[id=%d, productoId=%d, bodegaId=%d, cantidad=%s, tipoCarga='%s']",
                id, productoId, bodegaId, cantidad, tipoCarga
        );
    }
}
