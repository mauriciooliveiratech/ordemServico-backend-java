package br.com.os.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoResponseDTO(
        Long id,
        String numeroOS,
        LocalDateTime dtCriacao,
        String tecnico,
        String marca,
        String modelo,
        String servico,
        String observacao,
        BigDecimal valor,
        BigDecimal custo,
        String situacao
) {}
