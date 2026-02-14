package br.com.os.backend.dto;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record OrdemServicoCreateDTO(

        String numeroOS,
        LocalDateTime dtCriacao,
        Long usuarioId,
        Long marcaId,
        Long modeloId,
        Long servicoId,
        String observacao,
        BigDecimal valor,
        BigDecimal custo,
        String situacao


) {}

