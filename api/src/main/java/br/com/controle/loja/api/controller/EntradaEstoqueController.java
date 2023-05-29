package br.com.controle.loja.api.controller;

import br.com.controle.loja.api.domain.entrada.DadosCadastroEntrada;
import br.com.controle.loja.api.domain.entrada.EntradaEstoqueDTO;
import br.com.controle.loja.api.domain.entrada.EntradaEstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

}
