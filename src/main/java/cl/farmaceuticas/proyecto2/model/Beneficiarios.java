package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiarios")
public class Beneficiarios {

    @Id
    @Column(length = 12) // puedes ajustar el largo según tus necesidades
    private String rut;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String comuna;
    private String telefono;
    private String correo;
    private String documento;

    public Beneficiarios() {
        // Constructor vacío requerido por JPA
    }

    public Beneficiarios(String rut, String nombre, String apellido,
                         String fechaNacimiento, String sexo, String direccion, String comuna, String telefono, String correo, String documento) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido=apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.correo=correo;
        this.documento=documento;
    }

    // Getters y setters

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellidoPaterno(String apellido) {
        this.apellido = apellido;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
