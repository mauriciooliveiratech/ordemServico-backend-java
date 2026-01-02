package br.com.os.backend.controller;

import br.com.os.backend.dto.UsuarioCreateDTO;
import br.com.os.backend.dto.UsuarioResponseDTO;
import br.com.os.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioResponseDTO criar(@RequestBody UsuarioCreateDTO dto){
        return service.criar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar(){
        return service.listar();
    }

}
