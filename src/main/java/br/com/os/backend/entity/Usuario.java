package br.com.os.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome exibido
    @Column(nullable = false)
    private String nome;

    //Login (único)
    @Column(nullable = false)
    private String username;

    //senha (hash futuramente)
    @Column(nullable = false)
    private String senha;

    //Admin ou Tecnico
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;


}
