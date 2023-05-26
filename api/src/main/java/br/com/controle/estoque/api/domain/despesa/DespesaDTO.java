package br.com.controle.estoque.api.domain.despesa;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDespesa
) {

    public DespesaDTO(Despesa despesa) {
        this(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getDataDespesa());
    }

}
