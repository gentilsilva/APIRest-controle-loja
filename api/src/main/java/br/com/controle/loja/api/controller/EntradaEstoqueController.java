package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.entrada.DadosAtualizacaoEntradaEstoque;
import br.com.controle.loja.api.domain.entrada.DadosCadastroEntrada;
import br.com.controle.loja.api.domain.entrada.EntradaEstoqueDTO;
import br.com.controle.loja.api.domain.entrada.EntradaEstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("entrada-estoque")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueService entradaEstoqueService;

    @PostMapping
    public ResponseEntity<EntradaEstoqueDTO> cadastrarEntradaEAtualizarEstoque(@RequestBody @Valid DadosCadastroEntrada dadosCadastroEntrada, UriComponentsBuilder uriBuilder) {
        var entradaEstoqueDTO = entradaEstoqueService.incluirEntradaEAtualizarEstoque(dadosCadastroEntrada);
        var uri = uriBuilder.path("entrada-estoque/{id}").buildAndExpand(entradaEstoqueDTO.id()).toUri();
        return ResponseEntity.created(uri).body(entradaEstoqueDTO);
    }

    @GetMapping
    public ResponseEntity<List<EntradaEstoqueDTO>> consultarAtualizacoesEmEstoque() {
        return ResponseEntity.ok(entradaEstoqueService.listarAtualizacoesEmEstoque());
    }

    @GetMapping("{idProduto}")
    public ResponseEntity<EntradaEstoqueDTO> consultarEntradaEstoquePorIdProduto(@PathVariable Long idProduto) {
        return ResponseEntity.ok(entradaEstoqueService.listarEntradaEstoquePorIdProduto(idProduto));
    }

    @PutMapping
    public ResponseEntity<EntradaEstoqueDTO> atualizarEntradaEstoqueEEstoque(@RequestBody @Valid DadosAtualizacaoEntradaEstoque dadosAtualizacaoEntradaEstoque) {
        return ResponseEntity.ok(entradaEstoqueService.atualizarEntradaEEstoque(dadosAtualizacaoEntradaEstoque));
    }

}
