package br.com.controle.loja.api.domain.estoque;

import br.com.controle.loja.api.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Estoque")
@Table(name = "tb_estoque")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto idProduto;
    private Integer quantidade;


    public Estoque(DadosCadastroEstoque dadosCadastroEstoque, Produto produto) {
        this.idProduto = produto;
        this.quantidade = dadosCadastroEstoque.quantidade();
    }

}
