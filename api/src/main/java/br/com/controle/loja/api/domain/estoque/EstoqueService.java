package br.com.controle.loja.api.domain.estoque;

import br.com.controle.loja.api.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public EstoqueDTO incluirProdtuoEmEstoque(DadosCadastroEstoque dadosCadastroEstoque) {
        var produto = produtoRepository.getReferenceByIdAndAtivoTrue(dadosCadastroEstoque.idProduto());
        return new EstoqueDTO(estoqueRepository.save(new Estoque(dadosCadastroEstoque, produto)));
    }

    @Transactional(readOnly = true)
    public List<EstoqueDTO> listarProdutosEmEstoque() {
        return estoqueRepository.findAll().stream().map(EstoqueDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public EstoqueDTO listarEmEstoquePorid(Long id) {
        return new EstoqueDTO(estoqueRepository.getReferenceById(id));
    }

    @Transactional(readOnly = true)
    public EstoqueDTO listarProdutoEmEstoquePorIdProduto(Long idProduto) {
        return new EstoqueDTO(estoqueRepository.listarPorIdProduto(idProduto));
    }

    @Transactional
    public void atualizar(Integer atualizarQuantidade, Long idProduto) {
        var estoque = estoqueRepository.listarPorIdProduto(idProduto);
        estoque.atualizar(atualizarQuantidade);
    }

}
