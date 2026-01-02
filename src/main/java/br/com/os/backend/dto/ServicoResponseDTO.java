package br.com.os.backend.dto;

import java.math.BigDecimal;

public record ServicoResponseDTO (Long id, String nome, BigDecimal valor,Boolean ativo){
}
