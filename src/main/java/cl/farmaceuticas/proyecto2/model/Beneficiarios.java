package cl.farmaceuticas.proyecto2.model;

public class Beneficiarios {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String comuna;
    private String telefono;

    public Beneficiarios(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, String direccion, String comuna, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
    }

    // Getters and Setters
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
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
    /*@Override
    public String toString() {
        return "Beneficiarios{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(apellidoMaterno, apellidoPaterno, comuna, direccion, fechaNacimiento, nombre, sexo, telefono, rut);
        }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiarios)) return false;
        Beneficiarios that = (Beneficiarios) o;
        return Objects.equals(rut, that.rut);
    }*/

}
