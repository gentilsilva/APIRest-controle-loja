package br.com.controle.loja.api.domain.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosAtualizacaoEntradaEstoque(
        @NotNull
        Long id,
        Long idProduto,
        @PositiveOrZero
        Integer quantidade,
        @PastOrPresent
        LocalDate dataEntrada
) {
}
