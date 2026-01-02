package br.com.os.backend.dto;

import br.com.os.backend.entity.Perfil;

public record UsuarioResponseDTO (Long id, String nome, String username, Perfil perfil
) { }
