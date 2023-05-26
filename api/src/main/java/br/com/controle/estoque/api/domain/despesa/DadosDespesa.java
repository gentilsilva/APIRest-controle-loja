package br.com.controle.estoque.api.domain.despesa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDespesa(
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @PastOrPresent
        LocalDate dataDespesa
) {
}