package com.tpdevinhouse.devagro.grao.dtos;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GraoDTO {

    @NotBlank
    private String nomeGrao;

    private EmpresaModel empresaGrao;

    @NotNull
    private Integer tempoMedioColheita;

    public String getNomeGrao() {
        return nomeGrao;
    }

    public void setNomeGrao(String nomeGrao) {
        this.nomeGrao = nomeGrao;
    }

    public EmpresaModel getEmpresaGrao() {
        return empresaGrao;
    }

    public void setEmpresaGrao(EmpresaModel empresaGrao) {
        this.empresaGrao = empresaGrao;
    }

    public Integer getTempoMedioColheita() {
        return tempoMedioColheita;
    }

    public void setTempoMedioColheita(Integer tempoMedioColheita) {
        this.tempoMedioColheita = tempoMedioColheita;
    }
}
