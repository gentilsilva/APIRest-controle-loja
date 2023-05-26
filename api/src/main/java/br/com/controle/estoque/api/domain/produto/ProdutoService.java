package br.com.controle.estoque.api.domain.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public ProdutoDTO incluirProduto(DadosProduto dadosProduto) {
        return new ProdutoDTO(produtoRepository.save(new Produto(dadosProduto)));
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> listarProdutos() {
        return produtoRepository.findAllByAtivoTrue().stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO listarProduto(Long id) {
        return new ProdutoDTO(produtoRepository.getReferenceByIdAndAtivoTrue(id));
    }

    @Transactional
    public ProdutoDTO atualizarProduto(DadosAtualizacaoProduto dadosAtualizacaoProduto) {
        var produto = produtoRepository.getReferenceByIdAndAtivoTrue(dadosAtualizacaoProduto.id());
        produto.atualizarProduto(dadosAtualizacaoProduto);
        return new ProdutoDTO(produto);
    }

    @Transactional
    public void inativarProduto(Long id) {
        var produto = produtoRepository.getReferenceByIdAndAtivoTrue(id);
        produto.inativar();
    }
}
