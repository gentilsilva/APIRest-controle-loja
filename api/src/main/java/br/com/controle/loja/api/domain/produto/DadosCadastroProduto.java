package br.com.controle.loja.api.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProduto(
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
