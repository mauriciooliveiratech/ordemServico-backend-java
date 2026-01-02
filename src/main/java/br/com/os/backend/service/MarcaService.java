package br.com.os.backend;

import br.com.os.backend.entity.Marca;
import br.com.os.backend.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaService {
    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository){
        this.repository = repository;
    }

    public Marca salvar(String nome){
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new RuntimeException("Marca já cadastrada");
        }
            return repository.save(new Marca(null, nome));

    }

    public List<Marca> listar() {
        return repository.findAll();
    }





}
