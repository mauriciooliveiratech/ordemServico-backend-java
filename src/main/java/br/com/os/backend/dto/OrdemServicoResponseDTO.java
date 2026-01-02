package br.com.os.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoResponseDTO(
        Long id,
        String numeroOS,
        LocalDateTime dtCriacao,
        String marca,
        String modelo,
        String servico,
        String situacao,
        String tecnico,
        BigDecimal valor,
        BigDecimal custo


) {}
