package com.tpdevinhouse.devagro.empresa.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmpresaDTO {

    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    @Size(max = 18)
    private String cnpjEmpresa;

    @NotBlank
    private String enderecoEmpresa;

//    aplicar relacionamento
    @NotBlank
    private String fazendasEmpresa;

//    aplicar relacionamento
    @NotBlank
    private String funcinariosEmpresa;

    @NotBlank
    private String graosEmpresa;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getFazendasEmpresa() {
        return fazendasEmpresa;
    }

    public void setFazendasEmpresa(String fazendasEmpresa) {
        this.fazendasEmpresa = fazendasEmpresa;
    }

    public String getFuncinariosEmpresa() {
        return funcinariosEmpresa;
    }

    public void setFuncinariosEmpresa(String funcinariosEmpresa) {
        this.funcinariosEmpresa = funcinariosEmpresa;
    }

    public String getGraosEmpresa() {
        return graosEmpresa;
    }

    public void setGraosEmpresa(String graosEmpresa) {
        this.graosEmpresa = graosEmpresa;
    }

}
