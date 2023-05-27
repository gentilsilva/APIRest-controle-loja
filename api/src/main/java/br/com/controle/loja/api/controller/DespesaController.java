package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.despesa.DadosAtualizacaoDespesa;
import br.com.controle.loja.api.domain.despesa.DadosDespesa;
import br.com.controle.loja.api.domain.despesa.DespesaDTO;
import br.com.controle.loja.api.domain.despesa.DespesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaDTO> cadastrarDespesa(@RequestBody @Valid DadosDespesa dadosDespesa, UriComponentsBuilder uriBuilder) {
        var despesaDTO = despesaService.incluirDespesa(dadosDespesa);
        var uri = uriBuilder.path("despesas/{id}").buildAndExpand(despesaDTO.id()).toUri();
        return ResponseEntity.created(uri).body(despesaDTO);
    }

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> consultarDespesas() {
        return ResponseEntity.ok(despesaService.listarDespesas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDTO> consultarDespesaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(despesaService.listarDespesa(id));
    }

    @PutMapping
    public ResponseEntity<DespesaDTO> atualizarDespesaPorId(@RequestBody @Valid DadosAtualizacaoDespesa dadosAtualizacaoDespesa) {
        return ResponseEntity.ok(despesaService.atualizarDespesa(dadosAtualizacaoDespesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inativarDespesaPorId(@PathVariable Long id) {
        despesaService.inativarDespesa(id);
        return ResponseEntity.noContent().build();
    }

}
