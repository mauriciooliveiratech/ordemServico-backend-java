package br.com.os.backend.dto;

import br.com.os.backend.entity.Perfil;

public record UsuarioCreateDTO (String nome, String username, String senha, Perfil perfil
) { }
