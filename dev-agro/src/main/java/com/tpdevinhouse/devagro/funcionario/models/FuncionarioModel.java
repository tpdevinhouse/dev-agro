package com.tpdevinhouse.devagro.funcionario.models;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "DEV_AGRO_FUNCIONARIO")
public class FuncionarioModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuncinario;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeFuncinario;

    @Column(nullable = false, unique = true, length = 14)
    private String cpfFuncionario;

    @Column(nullable = false)
    private String enderecoFuncionario;

    @Column(nullable = false, length = 14)
    private String telefoneFuncionario;

    @Column(nullable = false, length = 1)
    private String sexoFuncionario;

    @Column(nullable = false, length = 10)
    private String dataNascFuncionario;

    @Column(nullable = false, length = 10)
    private String dataContratacaoFuncionario;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresaFuncionario;

    @Column(nullable = false)
    private LocalDateTime dataRegistroFuncionario;


    public Long getIdFuncinario() {
        return idFuncinario;
    }

    public void setIdFuncinario(Long idFuncinario) {
        this.idFuncinario = idFuncinario;
    }

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

    public LocalDateTime getDataRegistroFuncionario() {
        return dataRegistroFuncionario;
    }

    public void setDataRegistroFuncionario(LocalDateTime dataRegistroFuncionario) {
        this.dataRegistroFuncionario = dataRegistroFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FuncionarioModel)) return false;
        FuncionarioModel that = (FuncionarioModel) o;
        return getIdFuncinario().equals(that.getIdFuncinario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdFuncinario());
    }
}
