package com.tpdevinhouse.devagro.fazenda.services;

import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import com.tpdevinhouse.devagro.fazenda.repositories.FazendaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    final FazendaRepository fazendaRepository;

    public FazendaService(FazendaRepository fazendaRepository) {
        this.fazendaRepository = fazendaRepository;
    }

    @Transactional
    public FazendaModel cadastrarFazenda(FazendaModel fazendaModel) {
        return fazendaRepository.save(fazendaModel);
    }

    public boolean existsByNomeFazenda(String nomeFazenda) {
        return fazendaRepository.existsByNomeFazenda(nomeFazenda);
    }

    public List<FazendaModel> listarTodasAsFazendas() {
        return fazendaRepository.findAll();
    }

    public Optional<FazendaModel> listarFazendaPorId(Long id) {
        return fazendaRepository.findById(id);
    }

    @Transactional
    public void deletarFazenda(FazendaModel fazendaModel) {
        fazendaRepository.delete(fazendaModel);
    }


}
