package com.tpdevinhouse.devagro.fazenda.repositories;

import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FazendaRepository extends JpaRepository<FazendaModel, Long> {

    boolean existsByNomeFazenda(String nomeFazenda);

}
