package com.foliadas.foliadas_api.Repository;

import com.foliadas.foliadas_api.Model.FoliadaGrupo;
import com.foliadas.foliadas_api.Model.FoliadaGrupoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoliadaGrupoRepository extends JpaRepository<FoliadaGrupo, FoliadaGrupoId> {
    List<FoliadaGrupo> findByIdFoliadaId(int foliada_id);
}