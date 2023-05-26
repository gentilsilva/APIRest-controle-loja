package br.com.controle.estoque.api.domain.receita;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReceitaDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReceita
) {

    public ReceitaDTO(Receita receita) {
        this(receita.getId(), receita.getDescricao(), receita.getValor(), receita.getDataReceita());
    }

}
