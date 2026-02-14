package br.com.os.backend.service;

import br.com.os.backend.dto.OrdemServicoResponseDTO;
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

    public OrdemServico salvar(OrdemServico os) {
        if (os.getValor() == null) {
            os.setValor(BigDecimal.ZERO);
        }
        if (os.getCusto() == null) {
            os.setCusto(BigDecimal.ZERO);
        }



        return repository.save(os);
    }

    // 🔥 AGORA RETORNA DTO
    public List<OrdemServicoResponseDTO> listarPorPerfil(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<OrdemServico> lista;

        if (usuario.getPerfil() == Perfil.ADMIN) {
            lista = repository.findAll();
        } else {
            lista = repository.findByUsuarioId(usuarioId);
        }

        return lista.stream()
                .map(this::toDTO)
                .toList();
    }

    public OrdemServico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada"));
    }

    // 🔥 MAPPER CENTRAL
    private OrdemServicoResponseDTO toDTO(OrdemServico os) {
        return new OrdemServicoResponseDTO(
                os.getId(),
                os.getNumeroOS(),
                os.getDtCriacao(),
                os.getUsuario().getNome(),
                os.getMarca().getNome(),
                os.getModelo().getNome(),
                os.getServicos().getNome(),
                os.getObservacao(),
                os.getValor(),
                os.getCusto(),
                os.getSituacao()

        );
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("OS não encontrada");
        }
        repository.deleteById(id);
    }



}



