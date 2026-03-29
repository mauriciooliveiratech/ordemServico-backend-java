package br.com.os.backend.controller;

import br.com.os.backend.dto.MarcaRequestDTO;
import br.com.os.backend.dto.MarcaResponseDTO;
import br.com.os.backend.service.MarcaService;
import br.com.os.backend.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/marcas")


public class MarcaController {
    @Autowired
    private final MarcaService service;

    public MarcaController(MarcaService service){
        this.service = service;
    }

    @PostMapping
    public MarcaResponseDTO salvar (@RequestBody MarcaRequestDTO dto){

        return service.salvar(dto);
    }

    @GetMapping
    public List<MarcaResponseDTO> listar(){
        return service.listar();
    }
}
