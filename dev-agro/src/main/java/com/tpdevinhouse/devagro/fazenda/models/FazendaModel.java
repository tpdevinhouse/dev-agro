package com.tpdevinhouse.devagro.fazenda.models;

import com.tpdevinhouse.devagro.empresa.models.EmpresaModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "DEV_AGRO_FAZENDA")
public class FazendaModel implements Serializable {

    //  Serial ID usado para conversão de dados na hora de salvar no DB
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFazenda;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeFazenda;

    @Column(nullable = false)
    private String enderecoFazenda;

    @Column(nullable = false)
    private String tipoGrao;

//  Fazer estoque retonar o valor númerico + KG
    @Column(nullable = false)
    private Integer estoqueFazenda;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresaProprietariaFazenda;

    @Column(nullable = false)
    private LocalDateTime dataRegistroFazenda;

    public Long getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(Long idFazenda) {
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

    public EmpresaModel getEmpresaProprietariaFazenda() {
        return empresaProprietariaFazenda;
    }

    public void setEmpresaProprietariaFazenda(EmpresaModel empresaProprietariaFazenda) {
        this.empresaProprietariaFazenda = empresaProprietariaFazenda;
    }

    public LocalDateTime getDataRegistroFazenda() {
        return dataRegistroFazenda;
    }

    public void setDataRegistroFazenda(LocalDateTime dataRegistroFazenda) {
        this.dataRegistroFazenda = dataRegistroFazenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FazendaModel)) return false;
        FazendaModel that = (FazendaModel) o;
        return getIdFazenda().equals(that.getIdFazenda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdFazenda());
    }
}
