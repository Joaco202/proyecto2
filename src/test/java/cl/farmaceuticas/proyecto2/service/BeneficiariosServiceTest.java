package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.Beneficiarios;
import cl.farmaceuticas.proyecto2.repository.BeneficiariosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BeneficiariosServiceTest {

    @Mock
    private BeneficiariosRepository beneficiariosRepository;

    @InjectMocks
    private BeneficiariosService beneficiariosService;

    private Beneficiarios beneficiarioEjemplo;

    @BeforeEach
    void setUp() {
        beneficiarioEjemplo = new Beneficiarios();
        beneficiarioEjemplo.setRut("20.022.929-0");
        beneficiarioEjemplo.setComuna("Chillán");
        beneficiarioEjemplo.setDireccion("Calle Falsa 123");
        beneficiarioEjemplo.setTelefono("912345678");
    }

    @Test
    void testFindAll() {
        List<Beneficiarios> lista = Arrays.asList(beneficiarioEjemplo);
        when(beneficiariosRepository.findAll()).thenReturn(lista);

        List<Beneficiarios> resultado = beneficiariosService.findAll();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Chillán", resultado.get(0).getComuna());
    }

    @Test
    void testFindById() {
        when(beneficiariosRepository.findById(12345678L)).thenReturn(Optional.of(beneficiarioEjemplo));

        Optional<Beneficiarios> resultado = beneficiariosService.findById(12345678);

        assertTrue(resultado.isPresent());
        assertEquals("Chillán", resultado.get().getComuna());
    }

    @Test
    void testCreate() {
        when(beneficiariosRepository.save(beneficiarioEjemplo)).thenReturn(beneficiarioEjemplo);

        Beneficiarios creado = beneficiariosService.create(beneficiarioEjemplo);

        assertNotNull(creado);
        assertEquals("Calle Falsa 123", creado.getDireccion());
    }

    @Test
    void testUpdate() {
        when(beneficiariosRepository.findById(12345678L)).thenReturn(Optional.of(beneficiarioEjemplo));
        when(beneficiariosRepository.save(any(Beneficiarios.class))).thenAnswer(inv -> inv.getArgument(0));

        Beneficiarios nuevosDatos = new Beneficiarios();
        nuevosDatos.setComuna("San Carlos");
        nuevosDatos.setDireccion("Nueva Direccion");
        nuevosDatos.setTelefono("987654321");

        Optional<Beneficiarios> actualizado = beneficiariosService.update(12345678, nuevosDatos);

        assertTrue(actualizado.isPresent());
        assertEquals("San Carlos", actualizado.get().getComuna());
        assertEquals("Nueva Direccion", actualizado.get().getDireccion());
    }

    @Test
    void testDelete() {
        doNothing().when(beneficiariosRepository).deleteById(12345678L);
        beneficiariosService.delete(12345678);
        verify(beneficiariosRepository, times(1)).deleteById(12345678L);
    }
}
