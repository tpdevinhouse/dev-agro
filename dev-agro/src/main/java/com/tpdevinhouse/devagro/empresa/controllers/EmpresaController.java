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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dev-agro")
public class EmpresaController {

    final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/empresa")
    public ResponseEntity<Object> cadastraEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO) {
        var empresaModel = new EmpresaModel();

        BeanUtils.copyProperties(empresaDTO, empresaModel);

        empresaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.cadastrar(empresaModel));
    }

}
