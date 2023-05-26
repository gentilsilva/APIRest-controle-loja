package br.com.controle.estoque.api.domain.despesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Transactional
    public DespesaDTO incluirDespesa(DadosDespesa dadosDespesa) {
        return new DespesaDTO(despesaRepository.save(new Despesa(dadosDespesa)));
    }

    @Transactional(readOnly = true)
    public List<DespesaDTO> listarDespesas() {
        return despesaRepository.findAll().stream().map(DespesaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DespesaDTO listarDespesa(Long id) {
        return new DespesaDTO(despesaRepository.getReferenceById(id));
    }
}
