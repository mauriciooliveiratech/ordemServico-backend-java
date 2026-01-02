package br.com.os.backend.service;

import br.com.os.backend.MarcaService;
import br.com.os.backend.entity.Marca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "http://localhost:5173")

public class MarcaController {
    private final MarcaService service;

    public MarcaController(MarcaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@RequestBody String nome){
        return ResponseEntity.ok(service.salvar(nome));
    }

    @GetMapping
    public List<Marca> listar(){
        return service.listar();
    }
}
