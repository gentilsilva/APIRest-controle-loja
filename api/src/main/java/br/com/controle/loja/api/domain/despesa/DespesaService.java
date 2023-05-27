package br.com.controle.loja.api.domain.despesa;

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
        return despesaRepository.findAllByAtivoTrue().stream().map(DespesaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DespesaDTO listarDespesa(Long id) {
        return new DespesaDTO(despesaRepository.getReferenceByIdAndAtivoTrue(id));
    }

    @Transactional
    public DespesaDTO atualizarDespesa(DadosAtualizacaoDespesa dadosAtualizacaoDespesa) {
        var despesa = despesaRepository.getReferenceByIdAndAtivoTrue(dadosAtualizacaoDespesa.id());
        despesa.atualizarDespesa(dadosAtualizacaoDespesa);
        return new DespesaDTO(despesa);
    }

    @Transactional
    public void inativarDespesa(Long id) {
        var despesa = despesaRepository.getReferenceById(id);
        despesa.inativar();
    }
}
