package br.com.controle.estoque.api.domain.despesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaDTO incluirDespesa(DadosDespesa dadosDespesa) {
        var despesa = new Despesa(dadosDespesa);
        despesaRepository.save(despesa);
        return new DespesaDTO(despesa);
    }

}
