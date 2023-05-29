package br.com.controle.loja.api.domain.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record EntradaEstoqueDTO(
        Long id,
        Long idProduto,
        Integer quantidade,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataEntrada
) {

    public EntradaEstoqueDTO(EntradaEstoque entradaEstoque) {
        this(entradaEstoque.getId(), entradaEstoque.getIdProduto().getId(), entradaEstoque.getQuantidade(), entradaEstoque.getDataEntrada());
    }

}
