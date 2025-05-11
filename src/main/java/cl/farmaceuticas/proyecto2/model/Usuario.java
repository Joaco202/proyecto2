package cl.farmaceuticas.proyecto2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "clave_hash", nullable = false)
    private String claveHash;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo", unique = true)
    private String correo;


    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<CargasInventario> cargasInventario;

    @OneToMany(mappedBy = "usuario")
    private List<MovimientosInventario> movimientosInventario;

    @OneToMany(mappedBy = "usuario")
    private List<Ventas> ventas;

    @OneToMany(mappedBy = "usuario")
    private List<Dispensaciones> dispensaciones;

    @OneToMany(mappedBy = "usuario")
    private List<Dispersiones> dispersiones;

    @OneToMany(mappedBy = "usuario")
    private List<Cajas> cajas;

    @OneToMany(mappedBy = "usuario")
    private List<TransaccionesCaja> transaccionesCaja;

    public Usuario() {}

    public Usuario(String usuario, String claveHash, String nombre, String apellido, String correo, Rol rol) {
    public Usuario(String usuario, String claveHash, String nombre, String apellido, String correo, Rol rol) {
        this.usuario = usuario;
        this.claveHash = claveHash;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<CargasInventario> getCargasInventario() {
        return cargasInventario;
    }

    public void setCargasInventario(List<CargasInventario> cargasInventario) {
        this.cargasInventario = cargasInventario;
    }

    public List<MovimientosInventario> getMovimientosInventario() {
        return movimientosInventario;
    }

    public void setMovimientosInventario(List<MovimientosInventario> movimientosInventario) {
        this.movimientosInventario = movimientosInventario;
    }

    public List<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }

    public List<Dispensaciones> getDispensaciones() {
        return dispensaciones;
    }

    public void setDispensaciones(List<Dispensaciones> dispensaciones) {
        this.dispensaciones = dispensaciones;
    }

    public List<Dispersiones> getDispersiones() {
        return dispersiones;
    }

    public void setDispersiones(List<Dispersiones> dispersiones) {
        this.dispersiones = dispersiones;
    }

    public List<Cajas> getCajas() {
        return cajas;
    }

    public void setCajas(List<Cajas> cajas) {
        this.cajas = cajas;
    }

    public List<TransaccionesCaja> getTransaccionesCaja() {
        return transaccionesCaja;
    }

    public void setTransaccionesCaja(List<TransaccionesCaja> transaccionesCaja) {
        this.transaccionesCaja = transaccionesCaja;
    }

    @Override
    public String toString() {
        return String.format("Usuario[id=%d, usuario='%s']", id, usuario);
    }
}
