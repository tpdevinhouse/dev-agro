package com.tpdevinhouse.devagro.funcionario.controllers;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;
import com.tpdevinhouse.devagro.funcionario.dtos.FuncionarioDTO;
import com.tpdevinhouse.devagro.funcionario.models.FuncionarioModel;
import com.tpdevinhouse.devagro.funcionario.services.FuncionarioService;
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
public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

//  Cadastra um funcionário no (BD)
    @PostMapping("/funcionario")
    public ResponseEntity<Object> cadastraFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {

        Pattern patternTelefone = Pattern.compile("^\\([1-9]\\d\\)\\s9?\\d{4}\\d{4}$");
        Matcher matcherTelefone = patternTelefone.matcher(funcionarioDTO.getTelefoneFuncionario());

        if(!matcherTelefone.matches() & funcionarioDTO.getTelefoneFuncionario().length() < 14) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Telefone com formato inválido, adotar o padrão (00) 00000000");
        }

        Pattern patternCPF = Pattern.compile("^(\\d{2,3}|\\(\\d{2,3}\\))?[ ]?\\d{3,4}[-]?\\d{3,4}$");
        Matcher matcherCPF = patternCPF.matcher(funcionarioDTO.getCpfFuncionario());

        if(!matcherCPF.matches() & funcionarioDTO.getCpfFuncionario().length() < 14) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("CPF com formato inválido, adotar o padrão 000.000.000-00");
        }

//      Verifica se já existe o mesmo CPJ cadastrado no (BD)
        if(funcionarioService.existsByCpfFuncionario(funcionarioDTO.getCpfFuncionario())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado!");
        }

        var funcionarioModel = new FuncionarioModel();
        var empresaModel = new EmpresaModel();

        BeanUtils.copyProperties(funcionarioDTO, funcionarioModel, String.valueOf(empresaModel));
        funcionarioModel.setDataRegistroFuncionario(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.cadastrarFuncionario(funcionarioModel));

    }

//  Lista todos os funcionários do (BD)
    @GetMapping("/funcionario")
    public ResponseEntity<List<FuncionarioModel>> listarTodosFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listarTodosFuncionarios());
    }

//  Lista o funcionário por ID
    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Object> listarFuncionarioPorId(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.listarFuncionarioPorId(id);

//      Valida se o ID informado está cadastrado no (BD)
        if(funcionarioModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário(a) não localizado(a)!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioModelOptional.get());
    }

//  Deleta o funcionário no (BD)
    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<Object> deletarFuncionario(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.listarFuncionarioPorId(id);
        if (funcionarioModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
        funcionarioService.deletarFuncionario(funcionarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário(a) deletado(a) com sucesso!");
    }

//  Atualiza o funcionário no (BD)
    @PatchMapping("/funcionario/{id}")
    public ResponseEntity<Object> atualizaFuncionario(@PathVariable(value = "id") Long id,
                                                      @RequestBody @Valid FuncionarioDTO funcionarioDTO) {

        Pattern patternTelefone = Pattern.compile("^\\([1-9]\\d\\)\\s9?\\d{4}\\d{4}$");
        Matcher matcherTelefone = patternTelefone.matcher(funcionarioDTO.getTelefoneFuncionario());

        if(!matcherTelefone.matches() & funcionarioDTO.getTelefoneFuncionario().length() < 14) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Telefone com formato inválido, adotar o padrão (00) 00000000");
        }

        Pattern patternCPF = Pattern.compile("^(\\d{2,3}|\\(\\d{2,3}\\))?[ ]?\\d{3,4}[-]?\\d{3,4}$");
        Matcher matcherCPF = patternCPF.matcher(funcionarioDTO.getCpfFuncionario());

        if(!matcherCPF.matches() & funcionarioDTO.getCpfFuncionario().length() < 14) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("CPF com formato inválido, adotar o padrão 000.000.000-00");
        }

        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.listarFuncionarioPorId(id);
        if(!funcionarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário(a) não encontrado(a)");
        }

        var funcionarioModel = new FuncionarioModel();

        BeanUtils.copyProperties(funcionarioDTO, funcionarioModel);

//      Mantem o mesmo ID do funcionário no (BD)
        funcionarioModel.setIdFuncinario(funcionarioModelOptional.get().getIdFuncinario());

//      Mantem a mesma data de registro do funcionário no (BD)
        funcionarioModel.setDataRegistroFuncionario(funcionarioModelOptional.get().getDataRegistroFuncionario());

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.cadastrarFuncionario(funcionarioModel));

    }

}
