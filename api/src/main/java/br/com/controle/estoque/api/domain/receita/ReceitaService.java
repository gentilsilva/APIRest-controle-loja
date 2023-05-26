package br.com.controle.estoque.api.domain.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;


    public ReceitaDTO incluirReceita(DadosReceita dadosReceita) {
        return new ReceitaDTO(receitaRepository.save(new Receita(dadosReceita)));
    }
}
