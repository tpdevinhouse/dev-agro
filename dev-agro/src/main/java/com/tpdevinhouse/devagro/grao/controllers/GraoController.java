package com.tpdevinhouse.devagro.grao.controllers;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.grao.dtos.GraoDTO;
import com.tpdevinhouse.devagro.grao.models.GraoModel;
import com.tpdevinhouse.devagro.grao.services.GraoService;
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
public class GraoController {

    final GraoService graoService;

    public GraoController(GraoService graoService) {
        this.graoService = graoService;
    }

//  Cadastra um grão no (BD)
    @PostMapping("/grao")
    public ResponseEntity<Object> cadastraGrao(@RequestBody @Valid GraoDTO graoDTO) {

        var graoModel = new GraoModel();
        var empresaModel = new EmpresaModel();

        BeanUtils.copyProperties(graoDTO, graoModel, String.valueOf(empresaModel));
        graoModel.setDataRegistroGrao(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(graoService.cadastrarGrao(graoModel));

    }

//  Lista todos os grãos no (BD)
    @GetMapping("/grao")
    public ResponseEntity<List<GraoModel>> listarGraos() {
        return ResponseEntity.status(HttpStatus.OK).body(graoService.listarTodosOsGraos());
    }

//  Lista o grão por ID
    @GetMapping("/grao/{id}")
    public ResponseEntity<Object> listarGraoPorId(@PathVariable(value = "id") Long id) {
        Optional<GraoModel> graoModelOptional = graoService.listarGraoPorId(id);

        if(graoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grão não localizado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(graoModelOptional.get());
    }

//  Deleta o grão no (BD)
    @DeleteMapping("/grao/{id}")
    public ResponseEntity<Object> deletarGrao(@PathVariable(value = "id") Long id) {
        Optional<GraoModel> graoModelOptional = graoService.listarGraoPorId(id);
        if (graoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }

        graoService.deletarGrao(graoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Grão deletado com sucesso!");
    }

//  Atualiza os dados do grão
    @PatchMapping("/grao/{id}")
    public ResponseEntity<Object> atualizaGrao(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid GraoDTO graoDTO) {

        Optional<GraoModel> graoModelOptional = graoService.listarGraoPorId(id);
        if (!graoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada!");
        }

        var graoModel = new GraoModel();

        BeanUtils.copyProperties(graoDTO, graoModel);

//      Mantem o mesmo ID do grão
        graoModel.setIdGrao(graoModelOptional.get().getIdGrao());

//      Mantem a mesma data de registro do grão
        graoModel.setDataRegistroGrao(graoModelOptional.get().getDataRegistroGrao());

        return ResponseEntity.status(HttpStatus.OK).body(graoService.cadastrarGrao(graoModel));

    }

}
