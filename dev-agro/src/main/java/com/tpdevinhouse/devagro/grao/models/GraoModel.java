package com.tpdevinhouse.devagro.grao.models;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "DEV_AGRO_GRAO")
public class GraoModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGrao;

    @Column(nullable = false, length = 12)
    private String nomeGrao;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresaGrao;

    @Column(nullable = false)
    private Integer tempoMedioColheita;

    @Column(nullable = false)
    private LocalDateTime dataRegistroGrao;

    public Long getIdGrao() {
        return idGrao;
    }

    public void setIdGrao(Long idGrao) {
        this.idGrao = idGrao;
    }

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

    public LocalDateTime getDataRegistroGrao() {
        return dataRegistroGrao;
    }

    public void setDataRegistroGrao(LocalDateTime dataRegistroGrao) {
        this.dataRegistroGrao = dataRegistroGrao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraoModel)) return false;
        GraoModel graoModel = (GraoModel) o;
        return getIdGrao().equals(graoModel.getIdGrao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdGrao());
    }

}
