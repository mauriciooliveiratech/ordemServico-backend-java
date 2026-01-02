package br.com.os.backend.service;

import br.com.os.backend.entity.Situacao;
import br.com.os.backend.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoService {

    @Autowired
    private final SituacaoRepository repository;

    public SituacaoService(SituacaoRepository repository){
        this.repository = repository;
    }

    //lISTA DE TODAS AS SITUAÇÕES
    public List<Situacao> listar(){
        return repository.findAll();
    }

    //SALVA NOVA SITUACAO
    public Situacao salvar(Situacao situacao){
        if (situacao.getAtivo() == null){
            situacao.setAtivo(true);
        }
        return repository.save(situacao);
    }
}
