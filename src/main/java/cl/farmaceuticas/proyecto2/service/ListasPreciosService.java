package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.ListasPrecios;
import cl.farmaceuticas.proyecto2.repository.ListasPreciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListasPreciosService {

    private final ListasPreciosRepository listasPreciosRepository;

    @Autowired
    public ListasPreciosService(ListasPreciosRepository listasPreciosRepository) {
        this.listasPreciosRepository = listasPreciosRepository;
    }

    public List<ListasPrecios> findAll() {
        return listasPreciosRepository.findAll();
    }

    public Optional<ListasPrecios> findById(Integer id) {
        return listasPreciosRepository.findById(id);
    }


    public ListasPrecios create(ListasPrecios lista) {
        return listasPreciosRepository.save(lista);
    }

    public Optional<ListasPrecios> update(Integer id, ListasPrecios newData) {
        return listasPreciosRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(newData.getNombre());
                    existing.setFechaVigencia(newData.getFechaVigencia());
                    return listasPreciosRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        listasPreciosRepository.deleteById(id);
    }
}

