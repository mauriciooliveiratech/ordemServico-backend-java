package br.com.os.backend.service;

import br.com.os.backend.dto.UsuarioCreateDTO;
import br.com.os.backend.dto.UsuarioResponseDTO;
import br.com.os.backend.entity.Usuario;
import br.com.os.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioResponseDTO criar(UsuarioCreateDTO dto){

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.nome());
        usuario.setSenha(dto.username());
        usuario.setPerfil(dto.perfil());

            Usuario salvo = repository.save(usuario);

        return new UsuarioResponseDTO(
                salvo.getId(),
                salvo.getLogin(),
                salvo.getSenha(),
                salvo.getPerfil()
        );
    }

    public List<UsuarioResponseDTO> listar(){
        return repository.findAll().stream().map(u -> new UsuarioResponseDTO(
                u.getId(),
                u.getLogin(),
                u.getSenha(),
                u.getPerfil()
        ))
                .toList();
    }
}
