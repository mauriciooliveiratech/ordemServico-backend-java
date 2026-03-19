package br.com.os.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marca")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}
