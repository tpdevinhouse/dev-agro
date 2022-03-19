package com.tpdevinhouse.devagro.funcionario.repositories;

import com.tpdevinhouse.devagro.funcionario.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    boolean existsByCpfFuncionario(String cnpjEmpresa);

}
