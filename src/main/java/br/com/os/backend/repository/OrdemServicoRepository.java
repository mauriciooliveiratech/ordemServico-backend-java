package br.com.os.backend.repository;

import br.com.os.backend.dto.FaturamentoMensalDTO;
import br.com.os.backend.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    List<OrdemServico> findByUsuarioId(Long usuarioId);
    @Query("""
    SELECT new br.com.os.backend.dto.FaturamentoMensalDTO(
        MONTH(os.dtCriacao),
        COALESCE(SUM(os.valor), 0)
    )
    FROM OrdemServico os
    WHERE YEAR(os.dtCriacao) = :ano
      AND (:marcaId IS NULL OR os.marca.id = :marcaId)
      AND (:modeloId IS NULL OR os.modelo.id = :modeloId)
    GROUP BY MONTH(os.dtCriacao)
    ORDER BY MONTH(os.dtCriacao)
""")
    List<FaturamentoMensalDTO> faturamentoAnual(
            @Param("ano") Integer ano,
            @Param("marcaId") Long marcaId,
            @Param("modeloId") Long modeloId
    );
}







