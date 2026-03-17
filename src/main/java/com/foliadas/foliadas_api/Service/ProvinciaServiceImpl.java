package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.ProvinciaDTO;
import com.foliadas.foliadas_api.Model.Provincia;
import com.foliadas.foliadas_api.Repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

    @Autowired
    private final ProvinciaRepository provinciaRepository;


    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public List<ProvinciaDTO> getAll() {
        return provinciaRepository.findAll()
                .stream()
                .map(provincia -> new ProvinciaDTO(provincia.getId(), provincia.getNombre())).collect(Collectors.toList());
    }

    @Override
    public ProvinciaDTO getById(int id) {
        Provincia provincia= provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrada"));
        return new ProvinciaDTO(provincia.getId(), provincia.getNombre());
    }

    @Override
    public ProvinciaDTO create(ProvinciaDTO provinciaDTO) {
        Provincia provincia= new Provincia();
        provincia.setNombre(provinciaDTO.getNombre());
        Provincia saved= provinciaRepository.save(provincia);
        return new ProvinciaDTO(saved.getId(), saved.getNombre());
    }

    @Override
    public void delete(int id) {
        provinciaRepository.deleteById(id);
    }
}
