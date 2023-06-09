package br.com.controle.loja.api.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        String codigo,
        String descricao,
        BigDecimal valorUnitario
) {
}
