package br.com.os.backend.dto;

import br.com.os.backend.entity.OrdemServico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoResponseDTO(
        Long id,
        String numeroOS,
        LocalDateTime dtCriacao,
        String usuario,
        String marca,
        String modelo,
        String servico,
        String observacao,
        BigDecimal valor,
        BigDecimal custo,
        String situacao
) {
    public static OrdemServicoResponseDTO fromEntity(OrdemServico os) {
        return new OrdemServicoResponseDTO(
                os.getId(),
                os.getNumeroOS(),
                os.getDtCriacao(),
                os.getUsuario().getNome(),
                os.getMarca().getNome(),
                os.getModelo().getNome(),
                os.getServico().getNome(),
                os.getObservacao(),
                os.getValor(),
                os.getCusto(),
                os.getSituacao()
        );
    }
}
