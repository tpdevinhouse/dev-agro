package com.tpdevinhouse.devagro.grao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DEV_AGRO_GRAO")
public class GraoModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idGrao;

    @Column(nullable = false, length = 12)
    private String nomeGrao;

    @Column(nullable = false)
    private String empresaGrao;

    @Column(nullable = false)
    private Integer tempoMedioColheita;

    @Column(nullable = false)
    private LocalDateTime dataRegistroGrao;

    public UUID getIdGrao() {
        return idGrao;
    }

    public void setIdGrao(UUID idGrao) {
        this.idGrao = idGrao;
    }

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

    public LocalDateTime getDataRegistroGrao() {
        return dataRegistroGrao;
    }

    public void setDataRegistroGrao(LocalDateTime dataRegistroGrao) {
        this.dataRegistroGrao = dataRegistroGrao;
    }
}
