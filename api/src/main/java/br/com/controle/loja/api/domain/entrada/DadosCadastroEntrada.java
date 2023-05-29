package br.com.controle.loja.api.domain.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosCadastroEntrada(
        Long idProduto,
        @PositiveOrZero
        Integer quantidade,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @PastOrPresent
        LocalDate dataEntrada

) {
}
