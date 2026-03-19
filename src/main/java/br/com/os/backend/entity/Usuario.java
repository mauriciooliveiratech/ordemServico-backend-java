package br.com.os.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil; // 👈 enum, NÃO String

    private String nome; // ⚠️ importante para o erro 2
}
