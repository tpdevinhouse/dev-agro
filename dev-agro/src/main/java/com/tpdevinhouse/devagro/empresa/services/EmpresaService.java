package com.tpdevinhouse.devagro.empresa.services;

import com.tpdevinhouse.devagro.empresa.dtos.EmpresaDTO;
import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.empresa.repositories.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public boolean existsByCnpjEmpresa(String cnpjEmpresa) {
        return empresaRepository.existsByCnpjEmpresa(cnpjEmpresa);
    }

    public boolean existsByNomeEmpresa(String nomeEmpresa) {
        return empresaRepository.existsByNomeEmpresa(nomeEmpresa);
    }

    public List<EmpresaModel> listarTodasAsEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<EmpresaModel> listarPorId(UUID id) {
        return empresaRepository.findById(id);
    }

    @Transactional
    public void deletar(EmpresaModel empresaModel) {
        empresaRepository.delete(empresaModel);
    }
}
