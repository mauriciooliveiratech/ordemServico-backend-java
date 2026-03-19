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


    public Servico(Long id, String nome) {
        Id = id;
        this.nome = nome;

    }

    public Servico() {

    }

    public Long getId() {

        return Id;
    }

    public String getNome() {

        return nome;
    }


    public void setId(Long id) {

        Id = id;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }
}

