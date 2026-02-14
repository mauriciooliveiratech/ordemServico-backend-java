package br.com.os.backend.repository;

import br.com.os.backend.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;



public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    List<OrdemServico> findByUsuarioId(Long usuarioId);


}


