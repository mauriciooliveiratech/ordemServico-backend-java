package br.com.os.backend.service;

import br.com.os.backend.dto.ServicoRequestDTO;
import br.com.os.backend.dto.ServicoResponseDTO;
import br.com.os.backend.entity.Servico;
import br.com.os.backend.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public ServicoResponseDTO salvar(ServicoRequestDTO dto) {
        Servico servicos = new Servico();
        servicos.setNome(dto.nome());
        servicos.setValor(dto.valor());

        Servico salvo = repository.save(servicos);
        return toDTO(salvo);
    }

    public List<ServicoResponseDTO> listarAtivos() {
        return repository.findByAtivoTrue()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public void desativar(long id) {
        Servico servicos = repository.findById(id).orElseThrow();
        servicos.setAtivo(false);
        repository.save(servicos);
    }

    private ServicoResponseDTO toDTO(Servico s) {
        return new ServicoResponseDTO(s.getId(), s.getNome(), s.getValor(), s.getAtivo());
    };

}

