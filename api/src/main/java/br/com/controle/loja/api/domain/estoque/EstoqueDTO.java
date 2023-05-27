package br.com.controle.loja.api.domain.estoque;


public record EstoqueDTO(
        Long id,
        Long idProduto,
        Integer quantidade
) {

    public EstoqueDTO(Estoque estoque) {
        this(estoque.getId(), estoque.getIdProduto().getId(), estoque.getQuantidade());
    }

}
