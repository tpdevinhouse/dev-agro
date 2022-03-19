package com.tpdevinhouse.devagro.empresa.controllers;

import com.tpdevinhouse.devagro.empresa.dtos.EmpresaDTO;
import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.empresa.services.EmpresaService;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dev-agro")
public class EmpresaController {

    final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

//  Cria uma empresa no (BD)
    @PostMapping("/empresa")
    public ResponseEntity<Object> cadastraEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO) {

        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}");
        Matcher matcher = pattern.matcher(empresaDTO.getCnpjEmpresa());

        if(!matcher.matches() & empresaDTO.getCnpjEmpresa().length() < 18) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("CNPJ com formato inválido, adotar o padrão 00.000.000/0000-00!");
        }

//      Verifica se já existe o mesmo CNPJ no BD
        if(empresaService.existsByCnpjEmpresa(empresaDTO.getCnpjEmpresa())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CNPJ já cadastrado!");
        }

//      Verifica se já existe uma empresa com o mesmo nome no BD
        if(empresaService.existsByNomeEmpresa(empresaDTO.getNomeEmpresa())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome da empresa já cadastrada!");
        }

        var empresaModel = new EmpresaModel();

        BeanUtils.copyProperties(empresaDTO, empresaModel);
        empresaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.cadastrarEmpresa(empresaModel));
    }

//  Lista todas as empresas do (BD)
    @GetMapping("/empresa")
    public ResponseEntity<List<EmpresaModel>> listarEmpresas() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.listarTodasAsEmpresas());
    }

//  Lista a empresa por ID
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Object> listarEmpresaPorId(@PathVariable(value = "id") Long id) {
        Optional<EmpresaModel> empresaModelOptional = empresaService.listarPorId(id);

//      Valida se o ID informado está cadastrado no (BD)
        if(empresaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não localizada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaModelOptional.get());
    }

//  Deleta a empresa no (BD)
    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<Object> deletarEmpresa(@PathVariable(value = "id") Long id) {
        Optional<EmpresaModel> empresaModelOptional = empresaService.listarPorId(id);
        if (empresaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }
        empresaService.deletar(empresaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Empresa deletada com sucesso!");
    }

//  Atualiza os dados da empresa
    @PatchMapping("/empresa/{id}")
    public ResponseEntity<Object> atualizaEmpresa(@PathVariable(value = "id") Long id,
                                                  @RequestBody @Valid EmpresaDTO empresaDTO) {

        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}");
        Matcher matcher = pattern.matcher(empresaDTO.getCnpjEmpresa());

        if(!matcher.matches() & empresaDTO.getCnpjEmpresa().length() < 18) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("CNPJ com formato inválido, adotar o padrão 00.000.000/0000-00!");
        }

        Optional<EmpresaModel> empresaModelOptional = empresaService.listarPorId(id);
        if (!empresaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada!");
        }

        var empresaModel = new EmpresaModel();

        BeanUtils.copyProperties(empresaDTO, empresaModel);

//      Mantem o mesmo ID da empresa
        empresaModel.setIdEmpresa(empresaModelOptional.get().getIdEmpresa());

//      Mantem a mesma data de registro da empresa
        empresaModel.setDataRegistro(empresaModelOptional.get().getDataRegistro());

        return ResponseEntity.status(HttpStatus.OK).body(empresaService.cadastrarEmpresa(empresaModel));
    }

}
