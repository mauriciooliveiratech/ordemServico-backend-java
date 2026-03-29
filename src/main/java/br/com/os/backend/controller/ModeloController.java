package br.com.os.backend.controller;

import br.com.os.backend.dto.ModeloRequestDTO;
import br.com.os.backend.dto.ModeloResponseDTO;
import br.com.os.backend.entity.Marca;
import br.com.os.backend.entity.Modelo;
import br.com.os.backend.service.ModeloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "*")

public class ModeloController {
    private final ModeloService service;

    public ModeloController(ModeloService service){
        this.service = service;
    }

    @PostMapping
    public ModeloResponseDTO criar(@RequestBody ModeloRequestDTO dto){
        return service.salvar(dto);
    }

   // @GetMapping
    // public List<ModeloResponseDTO> listar() {
   //     return service.listar();
   // }


    @GetMapping
    public List<ModeloResponseDTO> listarPorMarca(@RequestParam Long marcaId){
        return service.listarPorMarca(marcaId);
    }




}
