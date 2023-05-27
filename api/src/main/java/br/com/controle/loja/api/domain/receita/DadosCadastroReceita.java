package br.com.controle.loja.api.domain.receita;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroReceita(
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @PastOrPresent
        LocalDate dataReceita
) {
}
