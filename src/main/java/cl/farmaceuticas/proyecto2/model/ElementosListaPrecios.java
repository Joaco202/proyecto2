package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "elementos_lista_precios")
public class ElementosListaPrecios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lista_precio_id", nullable = false)
    private Integer listaPrecioId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    public ElementosListaPrecios() {}

    public ElementosListaPrecios(Integer listaPrecioId, Integer productoId, BigDecimal precio) {
        this.listaPrecioId = listaPrecioId;
        this.productoId = productoId;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public Integer getListaPrecioId() {
        return listaPrecioId;
    }

    public void setListaPrecioId(Integer listaPrecioId) {
        this.listaPrecioId = listaPrecioId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ElementoListaPrecio[id=%d, listaPrecioId=%d, productoId=%d, precio=%s]", id, listaPrecioId, productoId, precio);
    }
}

