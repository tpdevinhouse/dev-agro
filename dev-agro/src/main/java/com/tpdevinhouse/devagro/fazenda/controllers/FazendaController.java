package com.tpdevinhouse.devagro.fazenda.controllers;

import com.tpdevinhouse.devagro.fazenda.dtos.FazendaDTO;
import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import com.tpdevinhouse.devagro.fazenda.services.FazendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dev-agro")
public class FazendaController {

    final FazendaService fazendaService;

    public FazendaController(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

//  Cria uma nova fazenda no (BD)
    @PostMapping("/fazenda")
    public ResponseEntity<Object> cadastraFazenda(@RequestBody @Valid FazendaDTO fazendaDTO) {

        if(fazendaService.existsByNomeFazenda(fazendaDTO.getNomeFazenda())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de fazenda já cadastrado!");
        }

        var fazendaModel = new FazendaModel();

        BeanUtils.copyProperties(fazendaDTO, fazendaModel);
        fazendaModel.setDataRegistroFazenda(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(fazendaService.cadastrarFazenda(fazendaModel));

    }

//  Lista todas as fazendas do (BD)
    @GetMapping("/fazenda")
    public ResponseEntity<List<FazendaModel>> listarFazendas() {
        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.listarTodasAsFazendas());
    }

//  Lista a fazenda por ID
    @GetMapping("/fazenda/{id}")
    public ResponseEntity<Object> listarFazendaPorId(@PathVariable(value = "id") UUID id) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if(fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não localizada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(fazendaModelOptional.get());
    }

//  Deleta a fazenda no (BD)
    @DeleteMapping("/fazenda/{id}")
    public ResponseEntity<Object> deletarFazenda(@PathVariable(value = "id") UUID id) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if(fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }

        fazendaService.deletarFazenda(fazendaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fazenda deletada com sucesso!");
    }

    @PatchMapping("/fazenda/{id}")
    public ResponseEntity<Object> atualizaFazenda(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid FazendaDTO fazendaDTO) {

        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if (!fazendaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
        }

        var fazendaModel = new FazendaModel();

        BeanUtils.copyProperties(fazendaDTO, fazendaModel);

//      Mantem o mesmo ID da fazenda
        fazendaModel.setIdFazenda(fazendaModelOptional.get().getIdFazenda());

//      Mantem a mesma data de registro da fazenda
        fazendaModel.setDataRegistroFazenda(fazendaModelOptional.get().getDataRegistroFazenda());

        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.cadastrarFazenda(fazendaModel));

    }

}
