package com.tpdevinhouse.devagro.empresa.repositories;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

    boolean existsByCnpjEmpresa(String cnpjEmpresa);
    boolean existsByNomeEmpresa(String nomeEmpresa);

}
