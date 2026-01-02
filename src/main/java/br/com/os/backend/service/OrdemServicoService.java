package br.com.os.backend.service;

import br.com.os.backend.entity.OrdemServico;
import br.com.os.backend.entity.Perfil;
import br.com.os.backend.entity.Usuario;
import br.com.os.backend.repository.OrdemServicoRepository;
import br.com.os.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public OrdemServicoService(
            OrdemServicoRepository repository,
            UsuarioRepository usuarioRepository
    ) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }
    // pega o valor do serviço

    public OrdemServico salvar(OrdemServico os) {
        if (os.getCusto() == null) {
            os.setCusto(BigDecimal.ZERO);
        }
        if (os.getValor() == null){
            os.setValor(BigDecimal.ZERO);
        }
        return repository.save(os);
    }


    public List<OrdemServico> listarPorPerfil(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getPerfil() == Perfil.ADMIN) {
            return repository.findAll();
        }

        return repository.findByUsuarioId(usuarioId);
    }


}


