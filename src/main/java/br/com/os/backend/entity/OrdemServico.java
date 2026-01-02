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
public class OrdemServico {
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

    //Situacao atual (Aberto, Em andamento, Finalizado)
    @ManyToOne
    @JoinColumn(name = "situacao_id", nullable = false)
    private Situacao situacao;

    @Column(name = "custo")
    private BigDecimal custo;

    //Valor cobrado
    @Column(nullable = false)
    private BigDecimal valor;

    //Observacoes
    private String observacao;

    //Data da criacao da os
    @Column(nullable = false)
    private LocalDateTime dtCriacao;

    @PrePersist
    public void prePersist() {
        this.dtCriacao = LocalDateTime.now();
    }


    public Servico getServico() {
        return servicos;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
}
