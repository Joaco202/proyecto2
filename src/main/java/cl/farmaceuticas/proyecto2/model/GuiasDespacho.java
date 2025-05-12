package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "guias_despacho")
public class GuiasDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_guia", nullable = false, unique = true)
    private String numeroGuia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", referencedColumnName = "id", nullable = false)
    private Facturas factura;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public GuiasDespacho() {}

    public GuiasDespacho(String numeroGuia, LocalDate fecha, Facturas factura, String destino) {
        this.numeroGuia = numeroGuia;
        this.fecha = fecha;
        this.factura = factura;
        this.destino = destino;
    }

    // Getters y Setters

    public Integer getId() { return id; }

    public String getNumeroGuia() { return numeroGuia; }
    public void setNumeroGuia(String numeroGuia) { this.numeroGuia = numeroGuia; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Facturas getFactura() { return factura; }
    public void setFactura(Facturas factura) { this.factura = factura; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    @Override
    public String toString() {
        return String.format("GuiaDespacho[id=%d, numeroGuia='%s', fecha=%s, facturaId=%d]", id, 
                numeroGuia, fecha, factura != null ? factura.getId() : "null");
    }
}

