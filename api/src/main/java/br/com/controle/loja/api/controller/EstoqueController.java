package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.estoque.DadosCadastroEstoque;
import br.com.controle.loja.api.domain.estoque.EstoqueDTO;
import br.com.controle.loja.api.domain.estoque.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueDTO> cadastrarNoEstoque(@RequestBody @Valid DadosCadastroEstoque dadosCadastroEstoque, UriComponentsBuilder uriBuilder) {
        var estoqueDTO = estoqueService.incluirNoEstoque(dadosCadastroEstoque);
        var uri = uriBuilder.path("estoque/{id}").buildAndExpand(estoqueDTO.id()).toUri();
        return ResponseEntity.created(uri).body(estoqueDTO);
    }

}
