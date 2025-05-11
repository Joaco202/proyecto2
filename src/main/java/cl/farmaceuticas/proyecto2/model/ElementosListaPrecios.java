package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "elementos_lista_precios")
public class ElementosListaPrecios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "precio", nullable = false)
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "lista_precio_id", nullable = false)
    private ListasPrecios listaPrecios;

    public ElementosListaPrecios() {}

    public ElementosListaPrecios(ListasPrecios listaPrecios, Producto producto, Integer precio) {
        this.listaPrecios = listaPrecios;
        this.producto = producto;
        this.precio = precio;
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

    public ListasPrecios getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(ListasPrecios listaPrecios) {
        this.listaPrecios = listaPrecios;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ElementoListaPrecio[id=%d, listaPrecioId=%d, productoId=%d, precio=%s]",
                id,
                listaPrecios != null ? listaPrecios.getId() : null,
                producto != null ? producto.getId() : null,
                precio);
    }
}
