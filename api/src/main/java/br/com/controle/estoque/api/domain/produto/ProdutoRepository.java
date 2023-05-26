package br.com.controle.estoque.api.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByAtivoTrue();

    Produto getReferenceByIdAndAtivoTrue(Long id);
}
