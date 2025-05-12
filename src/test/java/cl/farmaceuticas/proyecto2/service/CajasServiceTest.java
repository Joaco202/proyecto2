package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.Cajas;
import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.CajasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CajasServiceTest {

    @Mock
    private CajasRepository cajasRepository;

    @InjectMocks
    private CajasService cajasService;

    private Cajas caja;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario(); // Asumiendo que tienes una clase Usuario con setters
        // usuario.setId(1); // Solo si necesitas y tienes el setId

        caja = new Cajas();
        caja.setFechaRegistro(LocalDate.of(2024, 5, 1));
        caja.setMontoInicial(new BigDecimal("50000"));
        caja.setMontoFinal(new BigDecimal("150000"));
        caja.setUsuario(usuario);
    }

    @Test
    void testFindAll() {
        when(cajasRepository.findAll()).thenReturn(List.of(caja));

        List<Cajas> resultado = cajasService.findAll();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(new BigDecimal("50000"), resultado.get(0).getMontoInicial());
    }

    @Test
    void testFindById() {
        when(cajasRepository.findById(1)).thenReturn(Optional.of(caja));

        Optional<Cajas> resultado = cajasService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(new BigDecimal("150000"), resultado.get().getMontoFinal());
    }

    @Test
    void testSave() {
        when(cajasRepository.save(caja)).thenReturn(caja);

        Cajas guardada = cajasService.save(caja);

        assertNotNull(guardada);
        assertEquals(new BigDecimal("50000"), guardada.getMontoInicial());
        assertEquals(LocalDate.of(2024, 5, 1), guardada.getFechaRegistro());
    }

    @Test
    void testDeleteTrue() {
        when(cajasRepository.existsById(1)).thenReturn(true);
        doNothing().when(cajasRepository).deleteById(1);

        boolean resultado = cajasService.delete(1);

        assertTrue(resultado);
        verify(cajasRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteFalse() {
        when(cajasRepository.existsById(99)).thenReturn(false);

        boolean resultado = cajasService.delete(99);

        assertFalse(resultado);
        verify(cajasRepository, never()).deleteById(any());
    }
}
