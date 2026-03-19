package br.com.os.backend.service;

import br.com.os.backend.dto.FaturamentoMensalDTO;
import br.com.os.backend.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    private final OrdemServicoRepository repository;

    public RelatorioService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    public List<FaturamentoMensalDTO> faturamentoAnual(
            Integer ano,
            Long marcaId,
            Long modeloId
    ) {
        List<FaturamentoMensalDTO> dados = repository.faturamentoAnual(ano, marcaId, modeloId);

        Map<Integer, BigDecimal> mapa = dados.stream()
                .collect(Collectors.toMap(
                        FaturamentoMensalDTO::getMes,
                        FaturamentoMensalDTO::getTotal
                ));

        List<FaturamentoMensalDTO> resultado = new ArrayList<>();

        for (int mes = 1; mes <= 12; mes++) {

            resultado.add(
                    new FaturamentoMensalDTO(
                            mes,
                            mapa.getOrDefault(mes, BigDecimal.ZERO)
                    )
            );
        }

        return resultado;
    }
}