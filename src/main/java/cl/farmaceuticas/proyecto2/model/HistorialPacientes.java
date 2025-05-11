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

    public HistorialPacientes() {
    }

    public HistorialPacientes(Beneficiarios beneficiario, String datosHistorial) {
        this.beneficiario = beneficiario;
        this.datosHistorial = datosHistorial;
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
}
