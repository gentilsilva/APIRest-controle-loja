package br.com.controle.loja.api.domain.entrada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque, Long> {

    @Query("SELECT ee FROM EntradaEstoque ee WHERE ee.idProduto.id = :idProduto")
    EntradaEstoque listarPorIdProduto(Long idProduto);
}
