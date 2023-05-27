package br.com.controle.estoque.api.domain.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Transactional
    public ReceitaDTO incluirReceita(DadosReceita dadosReceita) {
        return new ReceitaDTO(receitaRepository.save(new Receita(dadosReceita)));
    }
    @Transactional(readOnly = true)
    public List<ReceitaDTO> listarReceitas() {
        return receitaRepository.findAllByAtivoTrue().stream().map(ReceitaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ReceitaDTO listarReceita(Long id) {
        return new ReceitaDTO(receitaRepository.getReferenceByIdAndAtivoTrue(id));
    }

    @Transactional
    public ReceitaDTO atualizarReceita(DadosAtualizacaoReceita dadosAtualizacaoReceita) {
        var receita = receitaRepository.getReferenceByIdAndAtivoTrue(dadosAtualizacaoReceita.id());
        receita.atualizar(dadosAtualizacaoReceita);
        return new ReceitaDTO(receita);
    }
}
