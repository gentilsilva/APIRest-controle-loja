package br.com.controle.loja.api.domain.estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    @Query("SELECT p FROM Estoque p WHERE p.idProduto.id = :id")
    Estoque listarPorIdProduto(Long id);
}
