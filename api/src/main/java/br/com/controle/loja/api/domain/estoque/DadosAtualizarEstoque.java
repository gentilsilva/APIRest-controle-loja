package br.com.controle.loja.api.domain.estoque;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosAtualizarEstoque(
        @NotNull
        Long idProduto,

        @NotNull
        @PositiveOrZero
        Integer quantidade

) {
}
