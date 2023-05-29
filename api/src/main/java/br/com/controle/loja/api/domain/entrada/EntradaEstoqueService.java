package br.com.controle.loja.api.domain.entrada;

import br.com.controle.loja.api.domain.estoque.EstoqueService;
import br.com.controle.loja.api.domain.produto.ProdutoRepository;
import br.com.controle.loja.api.domain.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntradaEstoqueService {

    @Autowired
    private EntradaEstoqueRepository entradaEstoqueRepository;

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public EntradaEstoqueDTO incluirEntradaEAtualizarEstoque(DadosCadastroEntrada dadosCadastroEntrada) {
        var produtoEstoque = estoqueService.listarEmEstoquePorid(dadosCadastroEntrada.idProduto());
        var produto = produtoRepository.getReferenceByIdAndAtivoTrue(dadosCadastroEntrada.idProduto());
        var atualizarQuantidade = produtoEstoque.quantidade() + dadosCadastroEntrada.quantidade();
        estoqueService.atualizar(atualizarQuantidade, dadosCadastroEntrada.idProduto());

        return new EntradaEstoqueDTO(entradaEstoqueRepository.save(new EntradaEstoque(dadosCadastroEntrada, produto)));
    }

    @Transactional(readOnly = true)
    public List<EntradaEstoqueDTO> listarAtualizacoesEmEstoque() {
        return entradaEstoqueRepository.findAll().stream().map(EntradaEstoqueDTO::new).toList();
    }

    public EntradaEstoqueDTO listarEntradaEstoquePorIdProduto(Long idProduto) {
        return new EntradaEstoqueDTO(entradaEstoqueRepository.listarPorIdProduto(idProduto));
    }
}
