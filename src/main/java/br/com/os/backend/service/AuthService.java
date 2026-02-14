package br.com.os.backend.service;

import br.com.os.backend.dto.AuthRequestDTO;
import br.com.os.backend.dto.AuthResponseDTO;
import br.com.os.backend.entity.Usuario;
import br.com.os.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository repository;

    public AuthResponseDTO login(AuthRequestDTO dto) {

        Usuario usuario = repository.findByUsername(dto.username())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(dto.senha())) {
            throw new RuntimeException("Senha inválida");
        }

        return new AuthResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getPerfil()
        );
    }
}
