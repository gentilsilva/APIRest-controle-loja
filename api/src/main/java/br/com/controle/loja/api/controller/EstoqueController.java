package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.estoque.EstoqueDTO;
import br.com.controle.loja.api.domain.estoque.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

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
