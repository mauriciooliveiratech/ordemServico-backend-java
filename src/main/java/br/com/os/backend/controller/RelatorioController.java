package br.com.os.backend.controller;

import br.com.os.backend.dto.FaturamentoMensalDTO;
import br.com.os.backend.service.OrdemServicoService;
import br.com.os.backend.service.RelatorioService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
@CrossOrigin(origins = "*")
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service, OrdemServicoService servicoService) {
        this.service = service;

    }

    @GetMapping("/faturamento-anual")
    public List<FaturamentoMensalDTO> faturamentoAnual(
            @RequestParam Integer ano,
            @RequestParam(required = false) Long marcaId,
            @RequestParam(required = false) Long modeloId

            ){
            return service.faturamentoAnual(ano, marcaId, modeloId);
    }

}
