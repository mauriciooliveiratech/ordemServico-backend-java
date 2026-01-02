package br.com.os.backend.controller;

import br.com.os.backend.dto.OrdemServicoCreateDTO;
import br.com.os.backend.dto.OrdemServicoResponseDTO;
import br.com.os.backend.entity.*;
import br.com.os.backend.repository.*;
import br.com.os.backend.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/os")
@CrossOrigin(origins = "http://localhost:5173")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService service;

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private SituacaoRepository situacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    // CRIAR OS
    @PostMapping
    public OrdemServicoResponseDTO criar(@RequestBody OrdemServicoCreateDTO dto) {

        OrdemServico os = new OrdemServico();
        os.setNumeroOS(dto.numeroOS());
        os.setObservacao(dto.observacao());
        os.setMarca(marcaRepository.findById(dto.marcaId()).orElseThrow());
        os.setModelo(modeloRepository.findById(dto.modeloId()).orElseThrow());
        os.setServicos(servicoRepository.findById(dto.servicoId()).orElseThrow());
        os.setSituacao(situacaoRepository.findById(dto.situacaoId()).orElseThrow());
        os.setUsuario(usuarioRepository.findById(dto.usuarioId()).orElseThrow());
        os.setCusto(dto.custo());
        os.setValor(dto.valor());

        OrdemServico salva = service.salvar(os);

        return new OrdemServicoResponseDTO(
                salva.getId(),
                salva.getNumeroOS(),
                salva.getDtCriacao(),
                salva.getMarca().getNome(),
                salva.getModelo().getNome(),
                salva.getServicos().getNome(),
                salva.getSituacao().getNome(),
                salva.getUsuario().getNome(),
                salva.getCusto(),
                salva.getValor()
        );
    }


    // LISTAR COM REGRA DE PERFIL
    @GetMapping
    public List<OrdemServicoResponseDTO> listarPorUsuario(
            @RequestParam Long usuarioId
    ) {
        return service.listarPorPerfil(usuarioId)
                .stream()
                .map(os -> new OrdemServicoResponseDTO(
                        os.getId(),
                        os.getNumeroOS(),
                        os.getDtCriacao(),
                        os.getMarca().getNome(),
                        os.getModelo().getNome(),
                        os.getServicos().getNome(),
                        os.getSituacao().getNome(),
                        os.getUsuario().getNome(),
                        os.getCusto(),
                        os.getValor()


                ))
                .toList();
    }
}


