package com.foliadas.foliadas_api.Repository;

import com.foliadas.foliadas_api.Model.Favorita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritaRepository extends JpaRepository<Favorita, Integer> {
    List<Favorita> findByUsuarioId(int usuario_id);
    Optional<Favorita> findByUsuarioIdAndFoliadaId(int usuario_id, int foliada_id);
}