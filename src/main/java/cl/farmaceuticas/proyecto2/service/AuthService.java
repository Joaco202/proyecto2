package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Rol;
import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.RolRepository;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public Optional<Usuario> registrar(String usuario, String clave, String nombre, String apellido, String correo, String nombreRol) {
        if (usuarioRepository.findByUsuario(usuario).isPresent()) {
            return Optional.empty(); // usuario ya existe
        }

        Rol rol = rolRepository.findByNombre(nombreRol);
        if (rol == null) return Optional.empty();


        Usuario nuevo = new Usuario();
        nuevo.setUsuario(usuario);
        nuevo.setClaveHash(clave); // opcional: hashearlo
        nuevo.setNombre(nombre);
        nuevo.setApellido(apellido);
        nuevo.setCorreo(correo);
        nuevo.setRol(rol);
        nuevo.setFechaCreacion(LocalDateTime.now());
        nuevo.setFechaModificacion(LocalDateTime.now());

        return Optional.of(usuarioRepository.save(nuevo));
    }
}
