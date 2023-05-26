package br.com.controle.estoque.api.controller;

import br.com.controle.estoque.api.domain.produto.DadosProduto;
import br.com.controle.estoque.api.domain.produto.ProdutoDTO;
import br.com.controle.estoque.api.domain.produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> incluirProduto(@RequestBody @Valid DadosProduto dadosProduto, UriComponentsBuilder uriBuilder) {
        ProdutoDTO produtoDTO = produtoService.incluirProduto(dadosProduto);
        var uri = uriBuilder.path("produtos/{id}").buildAndExpand(produtoDTO.id()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> listarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarProdutoPorId(id));
    }

}
