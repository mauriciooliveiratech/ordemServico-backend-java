package br.com.os.backend.controller;

import br.com.os.backend.dto.OrdemServicoCreateDTO;
import br.com.os.backend.dto.OrdemServicoRequest;
import br.com.os.backend.dto.OrdemServicoResponseDTO;
import br.com.os.backend.dto.OrdemServicoUpdateDTO;
import br.com.os.backend.entity.OrdemServico;
import br.com.os.backend.service.OrdemServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/os")
@CrossOrigin(origins = "https://ordem-servico-frontend-react.vercel.app")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<OrdemServicoResponseDTO> salvar(@RequestBody OrdemServicoRequest dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(
            @PathVariable Long id,
            @RequestBody OrdemServicoUpdateDTO dto
    ) {
        OrdemServico osAtualizada = service.atualizar(id, dto);
        return ResponseEntity.ok(osAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
