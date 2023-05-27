package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.produto.DadosAtualizacaoProduto;
import br.com.controle.loja.api.domain.produto.DadosCadastroProduto;
import br.com.controle.loja.api.domain.produto.ProdutoDTO;
import br.com.controle.loja.api.domain.produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriBuilder) {
        var produtoDTO = produtoService.incluirProduto(dadosCadastroProduto);
        var uri = uriBuilder.path("produtos/{id}").buildAndExpand(produtoDTO.id()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> consultarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> consultarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarProduto(id));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizarProdutoPorId(@RequestBody @Valid DadosAtualizacaoProduto dadosAtualizacaoProduto) {
        return ResponseEntity.ok(produtoService.atualizarProduto(dadosAtualizacaoProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inativarProdutoPorId(@PathVariable Long id) {
        produtoService.inativarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
