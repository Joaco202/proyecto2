package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_pacientes")
public class HistorialPacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rut_beneficiario", referencedColumnName = "rut")
    private Beneficiarios beneficiario;

    @Column(name = "datos_historial")
    private String datosHistorial;

    @Column(name = "fecha_registro")
    private String fechaRegistro;

    public HistorialPacientes() {
    }

    public HistorialPacientes(Beneficiarios beneficiario, String datosHistorial, String fechaRegistro) {
        this.beneficiario = beneficiario;
        this.datosHistorial = datosHistorial;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Beneficiarios getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiarios beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getDatosHistorial() {
        return datosHistorial;
    }

    public void setDatosHistorial(String datosHistorial) {
        this.datosHistorial = datosHistorial;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "HistorialPacientes{" + "id=" + id + ", beneficiario=" + beneficiario +
                ", datosHistorial='" + datosHistorial + '\'' + ", fechaRegistro='" + fechaRegistro + '\'' + '}';
    }
}
