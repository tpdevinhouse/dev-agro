package com.tpdevinhouse.devagro.grao.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GraoDTO {

    @NotBlank
    private String nomeGrao;

    @NotBlank
    private String empresaGrao;

    @NotNull
    private Integer tempoMedioColheita;

    public String getNomeGrao() {
        return nomeGrao;
    }

    public void setNomeGrao(String nomeGrao) {
        this.nomeGrao = nomeGrao;
    }

    public String getEmpresaGrao() {
        return empresaGrao;
    }

    public void setEmpresaGrao(String empresaGrao) {
        this.empresaGrao = empresaGrao;
    }

    public Integer getTempoMedioColheita() {
        return tempoMedioColheita;
    }

    public void setTempoMedioColheita(Integer tempoMedioColheita) {
        this.tempoMedioColheita = tempoMedioColheita;
    }
}
