package br.com.controle.loja.api.domain.entrada;

import br.com.controle.loja.api.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "EntradaEstoque")
@Table(name = "tb_entrada_estoque")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class EntradaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto idProduto;
    private Integer quantidade;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    public EntradaEstoque(DadosCadastroEntrada dadosCadastroEntrada, Produto produto) {
        this.idProduto = produto;
        this.quantidade = dadosCadastroEntrada.quantidade();
        this.dataEntrada = dadosCadastroEntrada.dataEntrada();
    }
}
