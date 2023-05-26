package br.com.controle.estoque.api.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosProduto(
        @NotNull
        String nome,
        @NotNull
        String codigo,
        @NotNull
        String descricao,
        @NotNull
        BigDecimal valorUnitario
) {
}
