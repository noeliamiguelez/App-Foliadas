package com.foliadas.foliadas_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoliadaGrupoRepository extends JpaRepository<FoliadaGrupo, FoliadaGrupoId> {
    List<FoliadaGrupo> findByIdFoliadaId(int foliada_id);
}