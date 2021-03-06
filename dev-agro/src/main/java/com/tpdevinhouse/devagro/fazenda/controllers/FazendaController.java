package com.tpdevinhouse.devagro.fazenda.controllers;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.fazenda.dtos.FazendaDTO;
import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import com.tpdevinhouse.devagro.fazenda.repositories.FazendaRepository;
import com.tpdevinhouse.devagro.fazenda.services.FazendaService;
import com.tpdevinhouse.devagro.grao.models.GraoModel;
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

        if (fazendaService.existsByNomeFazenda(fazendaDTO.getNomeFazenda())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de fazenda já cadastrado!");
        }

        var fazendaModel = new FazendaModel();
        var empresaModel = new EmpresaModel();
        var graoModel = new GraoModel();

        BeanUtils.copyProperties(fazendaDTO, fazendaModel, String.valueOf(empresaModel), String.valueOf(graoModel));
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
    public ResponseEntity<Object> listarFazendaPorId(@PathVariable(value = "id") Long id) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if (fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não localizada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(fazendaModelOptional.get());
    }


    //  Deleta a fazenda no (BD)
    @DeleteMapping("/fazenda/{id}")
    public ResponseEntity<Object> deletarFazenda(@PathVariable(value = "id") Long id) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if (fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }

        fazendaService.deletarFazenda(fazendaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fazenda deletada com sucesso!");
    }

    //  Atualizar dados da fazenda
    @PatchMapping("/fazenda/{id}")
    public ResponseEntity<Object> atualizaFazenda(@PathVariable(value = "id") Long id,
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


//  Adiciona estoque de grãos
    @GetMapping("/fazenda/estoque/adicionar/{id}/")
    public ResponseEntity<Object> adicionarEstoque(@PathVariable(value = "id") Long id,
                                                   @RequestParam(name = "adicionarEstoque") Integer adicionarEstoque) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if (fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não localizada!");
        }

        fazendaModelOptional.get().setEstoqueFazenda(fazendaModelOptional.get().getEstoqueFazenda() + adicionarEstoque);

        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.cadastrarFazenda(fazendaModelOptional.get()));
    }

    //  Adiciona estoque de grãos
    @GetMapping("/fazenda/estoque/retirar/{id}/")
    public ResponseEntity<Object> retirarEstoque(@PathVariable(value = "id") Long id,
                                                   @RequestParam(name = "retirarEstoque") Integer retirarEstoque) {
        Optional<FazendaModel> fazendaModelOptional = fazendaService.listarFazendaPorId(id);

        if (fazendaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não localizada!");
        }

        fazendaModelOptional.get().setEstoqueFazenda(fazendaModelOptional.get().getEstoqueFazenda() - retirarEstoque);

        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.cadastrarFazenda(fazendaModelOptional.get()));
    }

}
