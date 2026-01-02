package br.com.os.backend.repository;

import br.com.os.backend.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    boolean existsByNomeIgnoreCase(String nome);

}
