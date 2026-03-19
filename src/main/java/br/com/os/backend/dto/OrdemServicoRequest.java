package br.com.os.backend.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdemServicoRequest (
        Long usuarioId,
        String numeroOS,
        Long marcaId,
        Long modeloId,
        Long servicoId,
        String observacao,
        BigDecimal valor,
        BigDecimal custo,
        String situacao
){}
