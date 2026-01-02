package br.com.os.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicos")

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String nome;

    private BigDecimal valor;

    @Column(nullable = false)
    private Boolean ativo = true;

    public Servico(Long id, String nome, BigDecimal valor, Boolean ativo) {
        Id = id;
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }

    public Servico() {

    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
