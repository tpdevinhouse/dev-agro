package com.tpdevinhouse.devagro.funcionario.services;

import com.tpdevinhouse.devagro.funcionario.models.FuncionarioModel;
import com.tpdevinhouse.devagro.funcionario.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    public boolean existsByCpfFuncionario(String cpfFuncionario) {
        return funcionarioRepository.existsByCpfFuncionario(cpfFuncionario);
    }

    public List<FuncionarioModel> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> listarFuncionarioPorId(UUID id) {
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public void deletarFuncionario(FuncionarioModel funcionarioModel) {
        funcionarioRepository.delete(funcionarioModel);
    }
}
