package br.com.controle.estoque.api.domain.receita;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoReceita(
        @NotNull
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate dataReceita
) {
}
