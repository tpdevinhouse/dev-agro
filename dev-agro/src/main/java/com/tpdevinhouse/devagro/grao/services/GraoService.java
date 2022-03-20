package com.tpdevinhouse.devagro.grao.services;

import com.tpdevinhouse.devagro.grao.models.GraoModel;
import com.tpdevinhouse.devagro.grao.repositories.GraoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GraoService {

    final GraoRepository graoRepository;


    public GraoService(GraoRepository graoRepository) {
        this.graoRepository = graoRepository;
    }

    @Transactional
    public GraoModel cadastrarGrao(GraoModel graoModel) {
        return graoRepository.save(graoModel);
    }

    public List<GraoModel> listarTodosOsGraos() {
        return graoRepository.findAll();
    }

    public Optional<GraoModel> listarGraoPorId(Long id) {
        return graoRepository.findById(id);
    }

    @Transactional
    public void deletarGrao(GraoModel graoModel) {
        graoRepository.delete(graoModel);
    }

}
