package br.com.os.backend.repository;

import br.com.os.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
