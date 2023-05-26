package br.com.controle.estoque.api.controller;

import br.com.controle.estoque.api.domain.despesa.DadosDespesa;
import br.com.controle.estoque.api.domain.despesa.DespesaDTO;
import br.com.controle.estoque.api.domain.despesa.DespesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

}
