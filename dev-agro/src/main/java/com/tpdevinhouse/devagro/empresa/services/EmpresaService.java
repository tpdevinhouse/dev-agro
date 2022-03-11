package com.tpdevinhouse.devagro.empresa.services;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.empresa.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmpresaService {

// Ponto de injecao de dependencia do EmpresaRepository
   final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

//    Método cadastrar para criar uma nova empresa.
//    Ultilização do @Transactional, caso aconteça uma intermitencia no metodo seja possível fazer um rollback.
    @Transactional
    public EmpresaModel cadastrar(EmpresaModel empresaModel) {
        return empresaRepository.save(empresaModel);
    }
}
