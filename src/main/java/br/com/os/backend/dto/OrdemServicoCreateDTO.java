package br.com.os.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoCreateDTO(
        Long marcaId,
        Long modeloId,
        Long servicoId,
        Long situacaoId,
        Long usuarioId,
        String numeroOS,
        String observacao,
        BigDecimal valor,
        BigDecimal custo

) {}

