package br.com.os.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordem_servico")
public class

OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Numero da OS
    @Column(nullable = true)
    private String numeroOS;

    //Tecnico Responsável
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    //Data da criacao da os
    @Column(nullable = false)
    private LocalDateTime dtCriacao;

    @PrePersist
    public void prePersist() {
        this.dtCriacao = LocalDateTime.now();
    }
    //Marca do aparelho
    @ManyToOne
    @JoinColumn(nullable = false)
    private Marca marca;

    //Modelo do aparelho
    @ManyToOne
    @JoinColumn(nullable = false)
    private Modelo modelo;

    //Servico executado
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servicos;

    //Observacoes
    private String observacao;

    //Valor cobrado
    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "custo")
    private BigDecimal custo;

    @Column(nullable = false)
    private String situacao;

}
