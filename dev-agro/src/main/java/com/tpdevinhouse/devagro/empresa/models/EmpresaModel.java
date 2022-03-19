package com.tpdevinhouse.devagro.empresa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpdevinhouse.devagro.fazenda.models.FazendaModel;
import com.tpdevinhouse.devagro.funcionario.models.FuncionarioModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DEV_AGRO_EMPRESA")
public class EmpresaModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpresa;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeEmpresa;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpjEmpresa;

    @Column(nullable = false)
    private String enderecoEmpresa;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "empresaProprietariaFazenda")
    private List<FazendaModel> fazendaModels = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresaFuncionario")
    private List<FuncionarioModel> funcionarioModels = new ArrayList<>();

    public EmpresaModel(){}

    public EmpresaModel(Long id) {
        this.idEmpresa = id;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<FazendaModel> getFazendaModels() {
        return fazendaModels;
    }

    public List<FuncionarioModel> getFuncionarioModels() {
        return funcionarioModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpresaModel)) return false;
        EmpresaModel that = (EmpresaModel) o;
        return getIdEmpresa().equals(that.getIdEmpresa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEmpresa());
    }
}
