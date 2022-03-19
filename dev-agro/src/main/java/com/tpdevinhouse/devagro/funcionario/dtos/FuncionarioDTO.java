package com.tpdevinhouse.devagro.funcionario.dtos;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FuncionarioDTO {

    @NotBlank
    private String nomeFuncinario;

    @NotBlank
    @Size(max = 14)
    private String cpfFuncionario;

    @NotBlank
    private String enderecoFuncionario;

    @NotBlank
    @Size(max = 14)
    private String telefoneFuncionario;

    @NotBlank
    @Size(max = 1)
    private String sexoFuncionario;

    @NotBlank
    @Size(max = 10)
    private String dataNascFuncionario;

    @NotBlank
    @Size(max = 10)
    private String dataContratacaoFuncionario;


    private EmpresaModel empresaFuncionario;

    public String getNomeFuncinario() {
        return nomeFuncinario;
    }

    public void setNomeFuncinario(String nomeFuncinario) {
        this.nomeFuncinario = nomeFuncinario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getSexoFuncionario() {
        return sexoFuncionario;
    }

    public void setSexoFuncionario(String sexoFuncionario) {
        this.sexoFuncionario = sexoFuncionario;
    }

    public String getDataNascFuncionario() {
        return dataNascFuncionario;
    }

    public void setDataNascFuncionario(String dataNascFuncionario) {
        this.dataNascFuncionario = dataNascFuncionario;
    }

    public String getDataContratacaoFuncionario() {
        return dataContratacaoFuncionario;
    }

    public void setDataContratacaoFuncionario(String dataContratacaoFuncionario) {
        this.dataContratacaoFuncionario = dataContratacaoFuncionario;
    }

    public EmpresaModel getEmpresaFuncionario() {
        return empresaFuncionario;
    }

    public void setEmpresaFuncionario(EmpresaModel empresaFuncionario) {
        this.empresaFuncionario = empresaFuncionario;
    }
}
