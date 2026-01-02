package br.com.os.backend.service;

import br.com.os.backend.dto.ModeloRequestDTO;
import br.com.os.backend.dto.ModeloResponseDTO;
import br.com.os.backend.entity.Marca;
import br.com.os.backend.entity.Modelo;
import br.com.os.backend.repository.MarcaRepository;
import br.com.os.backend.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;


    public ModeloService (ModeloRepository modeloRepository,
                          MarcaRepository marcaRepository){
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    public ModeloResponseDTO salvar(ModeloRequestDTO dto) {
        Marca marca = marcaRepository.findById(dto.marcaId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
        if (modeloRepository.existsByNomeIgnoreCaseAndMarcaId(dto.nome(), dto.marcaId())) {
            throw new RuntimeException("Modelo já existe para esta marca");
        }

        Modelo modelo = new Modelo(null, dto.nome(), marca);
        Modelo salvo = modeloRepository.save(modelo);

        return new ModeloResponseDTO(salvo.getId(), salvo.getNome(), salvo.getMarca().getNome());
    }

    public List<ModeloResponseDTO> listarPorMarca(Long marcaId){
        return modeloRepository.findByMarcaId(marcaId).stream().map(m-> new ModeloResponseDTO(m.getId(),m.getNome(),m.getMarca().getNome())).toList();

    }


}
