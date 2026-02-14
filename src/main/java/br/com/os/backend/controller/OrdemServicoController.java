package br.com.os.backend.controller;

import br.com.os.backend.dto.OrdemServicoCreateDTO;
import br.com.os.backend.dto.OrdemServicoResponseDTO;
import br.com.os.backend.entity.*;
import br.com.os.backend.repository.*;
import br.com.os.backend.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private UsuarioRepository usuarioRepository;
    private OrdemServicoController ordemServicoService;

    // CRIAR
    @PostMapping
    public OrdemServicoResponseDTO criar(@RequestBody OrdemServicoCreateDTO dto) {

        OrdemServico os = new OrdemServico();
        os.setNumeroOS(dto.numeroOS());
        os.setObservacao(dto.observacao());
        os.setMarca(marcaRepository.findById(dto.marcaId()).orElseThrow());
        os.setModelo(modeloRepository.findById(dto.modeloId()).orElseThrow());
        os.setServicos(servicoRepository.findById(dto.servicoId()).orElseThrow());
        os.setCusto(dto.custo());
        os.setValor(dto.valor());
        os.setSituacao(dto.situacao());


        // 🔥 NÃO ESQUECER
        os.setUsuario(
                usuarioRepository.findById(dto.usuarioId()).orElseThrow()
        );

        OrdemServico salva = service.salvar(os);

        return service.listarPorPerfil(os.getUsuario().getId())
                .stream()
                .filter(dtoResp -> dtoResp.id().equals(salva.getId()))
                .findFirst()
                .orElseThrow();
    }

    // 🔥 LISTAR SIMPLES
    @GetMapping
    public List<OrdemServicoResponseDTO> listarPorUsuario(
            @RequestParam Long usuarioId
    ) {
        return service.listarPorPerfil(usuarioId);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public OrdemServicoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody OrdemServicoCreateDTO dto
    ) {
        OrdemServico os = service.buscarPorId(id);
        os.setNumeroOS(dto.numeroOS());
        os.setValor(dto.valor());
        os.setCusto(dto.custo());
        os.setObservacao(dto.observacao());
        os.setSituacao(dto.situacao());


        service.salvar(os);

        // 🔥 Retorna DTO correto
        return service.listarPorPerfil(os.getUsuario().getId())
                .stream()
                .filter(dtoResp -> dtoResp.id().equals(os.getId()))
                .findFirst()
                .orElseThrow();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}



