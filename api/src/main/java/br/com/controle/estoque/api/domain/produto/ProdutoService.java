package br.com.controle.estoque.api.domain.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDTO> listarProdutos() {
            return produtoRepository.findAll().stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO incluirProduto(DadosProduto dadosProduto) {
        var produto = new Produto(dadosProduto);
        produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO listarProdutoPorId(Long id) {
        return new ProdutoDTO(produtoRepository.getReferenceById(id));
    }
}
