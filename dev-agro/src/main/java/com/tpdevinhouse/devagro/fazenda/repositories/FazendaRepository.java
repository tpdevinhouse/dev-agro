package com.tpdevinhouse.devagro.fazenda.repositories;

import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FazendaRepository extends JpaRepository<FazendaModel, UUID> {

    boolean existsByNomeFazenda(String nomeFazenda);

}
