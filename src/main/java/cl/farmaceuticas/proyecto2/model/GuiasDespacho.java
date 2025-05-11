package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "guias_despacho")
public class GuiasDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_guia", nullable = false, unique = true)
    private String numeroGuia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "factura_id", nullable = false)
    private Integer facturaId;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public GuiasDespacho() {}

    public GuiasDespacho(String numeroGuia, LocalDate fecha, Integer facturaId, String destino) {
        this.numeroGuia = numeroGuia;
        this.fecha = fecha;
        this.facturaId = facturaId;
        this.destino = destino;
    }

    public Integer getId() { return id; }
    public String getNumeroGuia() { return numeroGuia; }
    public void setNumeroGuia(String numeroGuia) { this.numeroGuia = numeroGuia; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Integer getFacturaId() { return facturaId; }
    public void setFacturaId(Integer facturaId) { this.facturaId = facturaId; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return String.format("GuiaDespacho[id=%d, numeroGuia='%s', fecha=%s]", id, numeroGuia, fecha);
    }
}
