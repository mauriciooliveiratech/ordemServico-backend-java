package br.com.os.backend.controller;

import br.com.os.backend.dto.ServicoRequestDTO;
import br.com.os.backend.dto.ServicoResponseDTO;
import br.com.os.backend.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "http://localhost:5173")
public class ServicoController {
    private final ServicoService service;

    public ServicoController(ServicoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criar(@RequestBody ServicoRequestDTO dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public List<ServicoResponseDTO> listar(){
        return service.listarAtivos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id){
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }


}
