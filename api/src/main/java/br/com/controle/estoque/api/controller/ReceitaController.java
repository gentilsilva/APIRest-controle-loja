package br.com.controle.estoque.api.controller;

import br.com.controle.estoque.api.domain.receita.DadosAtualizacaoReceita;
import br.com.controle.estoque.api.domain.receita.DadosReceita;
import br.com.controle.estoque.api.domain.receita.ReceitaDTO;
import br.com.controle.estoque.api.domain.receita.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaDTO> cadastrarReceita(@RequestBody @Valid DadosReceita dadosReceita, UriComponentsBuilder uriBuider) {
        var receita = receitaService.incluirReceita(dadosReceita);
        var uri = uriBuider.path("receitas/{id}").buildAndExpand(receita.id()).toUri();
        return ResponseEntity.created(uri).body(receita);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> consultarReceitas() {
        return ResponseEntity.ok(receitaService.listarReceitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> consultarReceitaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(receitaService.listarReceita(id));
    }

    @PutMapping
    public ResponseEntity<ReceitaDTO> atualizarReceitaPorId(@RequestBody @Valid DadosAtualizacaoReceita dadosAtualizacaoReceita) {        ;
        return ResponseEntity.ok(receitaService.atualizarReceita(dadosAtualizacaoReceita));
    }

}
