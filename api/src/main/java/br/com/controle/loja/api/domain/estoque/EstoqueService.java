package br.com.controle.loja.api.domain.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

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

}
