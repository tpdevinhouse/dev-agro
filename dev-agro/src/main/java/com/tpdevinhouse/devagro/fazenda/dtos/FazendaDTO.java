package com.tpdevinhouse.devagro.fazenda.dtos;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FazendaDTO {

    @NotBlank
    private String nomeFazenda;

    @NotBlank
    private String enderecoFazenda;

//    aplicar relacionamento
    @NotBlank
    private String tipoGrao;

    @NotNull
    private Integer estoqueFazenda;

    private EmpresaModel empresaProprietariaFazenda;

    public String getNomeFazenda() {
        return nomeFazenda;
    }

    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    public String getEnderecoFazenda() {
        return enderecoFazenda;
    }

    public void setEnderecoFazenda(String enderecoFazenda) {
        this.enderecoFazenda = enderecoFazenda;
    }

    public String getTipoGrao() {
        return tipoGrao;
    }

    public void setTipoGrao(String tipoGrao) {
        this.tipoGrao = tipoGrao;
    }

    public Integer getEstoqueFazenda() {
        return estoqueFazenda;
    }

    public void setEstoqueFazenda(Integer estoqueFazenda) {
        this.estoqueFazenda = estoqueFazenda;
    }

    public EmpresaModel getEmpresaProprietariaFazenda() {
        return empresaProprietariaFazenda;
    }

    public void setEmpresaProprietariaFazenda(EmpresaModel empresaProprietariaFazenda) {
        this.empresaProprietariaFazenda = empresaProprietariaFazenda;
    }
}
