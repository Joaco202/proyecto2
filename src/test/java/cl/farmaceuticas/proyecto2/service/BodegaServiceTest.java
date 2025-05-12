package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.Bodega;
import cl.farmaceuticas.proyecto2.repository.BodegaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BodegaServiceTest {

    @Mock
    private BodegaRepository bodegaRepository;

    @InjectMocks
    private BodegaService bodegaService;

    private Bodega bodegaEjemplo;

    @BeforeEach
    void setUp() {
        bodegaEjemplo = new Bodega();
        bodegaEjemplo.setId(1);
        bodegaEjemplo.setNombre("Central");
        bodegaEjemplo.setDescripcion("Bodega principal");
    }

    @Test
    void testFindAll() {
        List<Bodega> bodegas = List.of(bodegaEjemplo);
        when(bodegaRepository.findAll()).thenReturn(bodegas);

        List<Bodega> resultado = bodegaService.findAll();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Central", resultado.get(0).getNombre());
    }

    @Test
    void testFindById() {
        when(bodegaRepository.findById(1)).thenReturn(Optional.of(bodegaEjemplo));

        Optional<Bodega> resultado = bodegaService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals("Central", resultado.get().getNombre());
    }

    @Test
    void testSave() {
        when(bodegaRepository.save(bodegaEjemplo)).thenReturn(bodegaEjemplo);

        Bodega guardada = bodegaService.save(bodegaEjemplo);

        assertNotNull(guardada);
        assertEquals("Central", guardada.getNombre());
    }

    @Test
    void testUpdate() {
        Bodega nuevosDatos = new Bodega();
        nuevosDatos.setNombre("Actualizada");
        nuevosDatos.setDescripcion("Bodega actualizada");

        when(bodegaRepository.findById(1)).thenReturn(Optional.of(bodegaEjemplo));
        when(bodegaRepository.save(any(Bodega.class))).thenAnswer(inv -> inv.getArgument(0));

        Bodega actualizada = bodegaService.update(1, nuevosDatos);

        assertEquals("Actualizada", actualizada.getNombre());
        assertEquals("Bodega actualizada", actualizada.getDescripcion());
    }

    @Test
    void testUpdateNotFound() {
        when(bodegaRepository.findById(999)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            bodegaService.update(999, new Bodega());
        });

        assertEquals("Bodega no encontrada", ex.getMessage());
    }

    @Test
    void testDeleteTrue() {
        when(bodegaRepository.existsById(1)).thenReturn(true);
        doNothing().when(bodegaRepository).deleteById(1);

        boolean eliminado = bodegaService.delete(1);

        assertTrue(eliminado);
        verify(bodegaRepository).deleteById(1);
    }

    @Test
    void testDeleteFalse() {
        when(bodegaRepository.existsById(999)).thenReturn(false);

        boolean eliminado = bodegaService.delete(999);

        assertFalse(eliminado);
        verify(bodegaRepository, never()).deleteById(any());
    }
}

