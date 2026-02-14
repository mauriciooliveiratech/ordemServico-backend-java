package br.com.os.backend.dto;

import br.com.os.backend.entity.Perfil;

public record AuthResponseDTO(
        Long id,
        String nome,
        Perfil perfil
) {}
