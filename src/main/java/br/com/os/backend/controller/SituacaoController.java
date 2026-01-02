package br.com.os.backend.controller;

import br.com.os.backend.entity.Situacao;
import br.com.os.backend.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/situacoes")
@CrossOrigin(origins = "http://localhost:5173") // libera acesso do frontend
public class SituacaoController {

    @Autowired
    private final SituacaoService service;

    public SituacaoController(SituacaoService service){
        this.service = service;
    }

    //GET lista situacoes
    @GetMapping
    public List<Situacao> listar(){
        return service.listar();

    }
    // POST cria situacao
    @PostMapping
    public Situacao salvar(@RequestBody Situacao situacao){
        return service.salvar(situacao);
    }

}
