package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Intentando cargar usuario: {}", username);
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> {
                    logger.error("Usuario no encontrado: {}", username);
                    return new UsernameNotFoundException("Usuario no encontrado: " + username);
                });

        logger.info("Usuario encontrado: {} - rol: {}", usuario.getUsuario(), usuario.getRol().getNombre());

        // En debug puedes agregar el hash para verificar que se esté recuperando (¡con cuidado!)
        logger.debug("Hash de contraseña recuperado: {}", usuario.getClaveHash());

        return User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getClaveHash())
                .roles(usuario.getRol().getNombre())
                .build();
    }
}
