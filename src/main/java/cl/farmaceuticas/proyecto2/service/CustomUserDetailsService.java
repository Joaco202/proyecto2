package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Construimos UserDetails con el nombre, contraseña (hasheada) y roles
        return User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getClaveHash())
                .roles(usuario.getRol().getNombre()) // Asumiendo rol.nombre = "ADMIN" o "USER", etc.
                .build();
    }
}
