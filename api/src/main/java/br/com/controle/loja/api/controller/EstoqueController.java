package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.estoque.DadosCadastroEstoque;
import br.com.controle.loja.api.domain.estoque.EstoqueDTO;
import br.com.controle.loja.api.domain.estoque.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueDTO> cadastrarProdutoEmEstoque(@RequestBody @Valid DadosCadastroEstoque dadosCadastroEstoque, UriComponentsBuilder uriBuilder) {
        var estoqueDTO = estoqueService.incluirProdtuoEmEstoque(dadosCadastroEstoque);
        var uri = uriBuilder.path("estoque/{id}").buildAndExpand(estoqueDTO.id()).toUri();
        return ResponseEntity.created(uri).body(estoqueDTO);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> consultarProdutosEmEstoque() {
        return ResponseEntity.ok(estoqueService.listarProdutosEmEstoque());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDTO> consultarEmEstoquePorId(@PathVariable Long id) {
        return ResponseEntity.ok(estoqueService.listarEmEstoquePorid(id));
    }

    @GetMapping("/{idProduto}/produto")
    public ResponseEntity<EstoqueDTO> consultarProdutoEmEstoquePorIdProduto(@PathVariable Long idProduto) {
        return ResponseEntity.ok(estoqueService.listarProdutoEmEstoquePorIdProduto(idProduto));
    }

}
