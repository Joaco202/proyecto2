package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Rol;
import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import cl.farmaceuticas.proyecto2.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public Optional<Usuario> registrar(String usuario, String claveHash, String nombre, String apellido, String correo, String rolNombre) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsuario(usuario)) {
            return Optional.empty(); // Usuario ya existe
        }

        // Buscar el rol por nombre
        Rol rol = rolRepository.findByNombre(rolNombre);
        if (rol == null) {
            return Optional.empty(); // Rol no encontrado
        }

        // Crear y guardar el nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setClaveHash(claveHash);
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setRol(rol);

        Usuario guardado = usuarioRepository.save(nuevoUsuario);
        return Optional.of(guardado);
    }
}
