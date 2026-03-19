package br.com.os.backend.service;

import br.com.os.backend.dto.OrdemServicoRequest;
import br.com.os.backend.dto.OrdemServicoResponseDTO;
import br.com.os.backend.dto.OrdemServicoUpdateDTO;
import br.com.os.backend.entity.OrdemServico;
import br.com.os.backend.entity.Servico;
import br.com.os.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final MarcaRepository marcaRepository;
    private final ModeloRepository modeloRepository;
    private final ServicoRepository servicoRepository;

    public OrdemServicoService(
            OrdemServicoRepository ordemServicoRepository,
            UsuarioRepository usuarioRepository,
            MarcaRepository marcaRepository,
            ModeloRepository modeloRepository,
            ServicoRepository servicoRepository
    ) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
        this.servicoRepository = servicoRepository;
    }

    @PostMapping
    public OrdemServicoResponseDTO salvar(OrdemServicoRequest dto) {

        OrdemServico os = new OrdemServico();

        os.setNumeroOS(dto.numeroOS());
        os.setDtCriacao(LocalDateTime.now());
        os.setObservacao(dto.observacao());
        os.setValor(dto.valor() != null ? dto.valor() : BigDecimal.ZERO);
        os.setCusto(dto.custo() != null ? dto.custo() : BigDecimal.ZERO);
        os.setSituacao(dto.situacao());

        os.setUsuario(
                usuarioRepository.findById(dto.usuarioId())
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        );

        os.setMarca(
                marcaRepository.findById(dto.marcaId())
                        .orElseThrow(() -> new RuntimeException("Marca não encontrada"))
        );

        os.setModelo(
                modeloRepository.findById(dto.modeloId())
                        .orElseThrow(() -> new RuntimeException("Modelo não encontrado"))
        );

        os.setServico(
                servicoRepository.findById(dto.servicoId())
                        .orElseThrow(() -> new RuntimeException("Serviço não encontrado"))
        );

        OrdemServico salva = ordemServicoRepository.save(os);
        return toDTO(salva);
    }
    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    @PutMapping
    public OrdemServico atualizar(Long id, OrdemServicoUpdateDTO dto) {

        OrdemServico os = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada"));

        os.setNumeroOS(dto.getNumeroOS());
        os.setDtCriacao(LocalDateTime.now());
        os.setObservacao(dto.getObservacao());
        os.setValor(dto.getValor());
        os.setCusto(dto.getCusto());
        os.setSituacao(dto.getSituacao());

        if (dto.getServicoId() != null) {
            Servico servico = servicoRepository.findById(dto.getServicoId())
                    .orElseThrow(() -> new RuntimeException("Serviço inválido"));
            os.setServico(servico);
        }

        return ordemServicoRepository.save(os);
    }

    @DeleteMapping
    public void deletar(Long id) {
        if (!ordemServicoRepository.existsById(id)) {
            throw new RuntimeException("OS não encontrada");
        }
        ordemServicoRepository.deleteById(id);
    }
    public OrdemServico buscarPorId(Long id) {
        return ordemServicoRepository.findById(id)
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
                os.getServico().getNome(),
                os.getObservacao(),
                os.getValor(),
                os.getCusto(),
                os.getSituacao()
        );
    }

}
