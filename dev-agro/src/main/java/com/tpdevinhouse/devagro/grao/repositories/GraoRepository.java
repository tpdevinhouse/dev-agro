package com.tpdevinhouse.devagro.grao.repositories;

import com.tpdevinhouse.devagro.grao.models.GraoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GraoRepository extends JpaRepository<GraoModel, Long> {
}
