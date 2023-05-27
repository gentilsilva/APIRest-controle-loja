package br.com.controle.loja.api.domain.produto;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        String codigo,
        BigDecimal valorUnitario
) {
    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getCodigo(), produto.getValorUnitario());
    }
}
