package com.tpdevinhouse.devagro.empresa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DEV_AGRO_EMPRESA")
public class EmpresaModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmpresa;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeEmpresa;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpjEmpresa;

    @Column(nullable = false)
    private String enderecoEmpresa;

    @Column(nullable = false)
    private String fazendasEmpresa;

    @Column(nullable = false)
    private String funcinariosEmpresa;

    @Column(nullable = false)
    private String graosEmpresa;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    public UUID getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(UUID idEmpresa) {
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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
