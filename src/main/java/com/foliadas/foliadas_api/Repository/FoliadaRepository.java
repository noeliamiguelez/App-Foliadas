package com.foliadas.foliadas_api.Repository;

import com.foliadas.foliadas_api.Model.Foliada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoliadaRepository extends JpaRepository<Foliada, Integer> {
    List<Foliada> findByProvincia(Provincia provincia);
    List<Foliada> findByNomeContainingIgnoreCase(String nome);
}
