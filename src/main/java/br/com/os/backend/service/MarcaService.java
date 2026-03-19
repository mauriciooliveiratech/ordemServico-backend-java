package br.com.os.backend.service;

import br.com.os.backend.dto.MarcaRequestDTO;
import br.com.os.backend.dto.MarcaResponseDTO;
import br.com.os.backend.entity.Marca;
import br.com.os.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository){
        this.repository = repository;
    }
    public MarcaResponseDTO salvar(MarcaRequestDTO dto){
        Marca marca = new Marca();
        marca.setNome(dto.nome());

        Marca salva = repository.save(marca);
        return new MarcaResponseDTO(
                salva.getId(),
                salva.getNome()
        );
    }


    public List<MarcaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(m -> new MarcaResponseDTO(m.getId(), m.getNome()))
                .toList();
    }





}
