package br.com.controle.loja.api.domain.despesa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findAllByAtivoTrue();

    Despesa getReferenceByIdAndAtivoTrue(Long id);
}
