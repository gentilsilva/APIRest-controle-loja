package br.com.controle.loja.api.domain.estoque;

import br.com.controle.loja.api.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public EstoqueDTO incluirNoEstoque(DadosCadastroEstoque dadosCadastroEstoque) {
        var produto = produtoRepository.getReferenceByIdAndAtivoTrue(dadosCadastroEstoque.idProduto());
        return new EstoqueDTO(estoqueRepository.save(new Estoque(dadosCadastroEstoque, produto)));
    }
}
