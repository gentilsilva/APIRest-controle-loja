package br.com.controle.loja.api.domain.despesa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroDespesa(
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @PastOrPresent
        LocalDate dataDespesa
) {
}
