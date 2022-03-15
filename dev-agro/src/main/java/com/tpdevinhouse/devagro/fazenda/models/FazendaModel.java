package com.tpdevinhouse.devagro.fazenda.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DEV_AGRO_FAZENDA")
public class FazendaModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFazenda;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeFazenda;

    @Column(nullable = false)
    private String enderecoFazenda;

    @Column(nullable = false)
    private String tipoGrao;

//  Fazer estoque retonar o valor númerico + KG
    @Column(nullable = false)
    private Integer estoqueFazenda;

    @Column(nullable = false)
    private String empresaProprietariaFazenda;

    @Column(nullable = false)
    private LocalDateTime dataRegistroFazenda;

    public UUID getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(UUID idFazenda) {
        this.idFazenda = idFazenda;
    }

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

    public String getEmpresaProprietariaFazenda() {
        return empresaProprietariaFazenda;
    }

    public void setEmpresaProprietariaFazenda(String empresaProprietariaFazenda) {
        this.empresaProprietariaFazenda = empresaProprietariaFazenda;
    }

    public LocalDateTime getDataRegistroFazenda() {
        return dataRegistroFazenda;
    }

    public void setDataRegistroFazenda(LocalDateTime dataRegistroFazenda) {
        this.dataRegistroFazenda = dataRegistroFazenda;
    }
}
