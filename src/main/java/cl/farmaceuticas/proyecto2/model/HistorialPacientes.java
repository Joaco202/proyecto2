package cl.farmaceuticas.proyecto2.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "historial_pacientes")
public class HistorialPacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "beneficiario_id", nullable = false)
    private Integer beneficiarioId;

    @Column(name = "datos_historial")
    private String datosHistorial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public HistorialPacientes() {}

    public HistorialPacientes(Integer beneficiarioId, String datosHistorial) {
        this.beneficiarioId = beneficiarioId;
        this.datosHistorial = datosHistorial;
    }

    public Integer getId() { return id; }
    public Integer getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Integer beneficiarioId) { this.beneficiarioId = beneficiarioId; }
    public String getDatosHistorial() { return datosHistorial; }
    public void setDatosHistorial(String datosHistorial) { this.datosHistorial = datosHistorial; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

    @Override
    public String toString() {
        return String.format("HistorialPaciente[id=%d, beneficiarioId=%d]", id, beneficiarioId);
    }
}

