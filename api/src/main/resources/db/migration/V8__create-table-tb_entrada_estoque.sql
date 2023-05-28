CREATE TABLE tb_entrada_estoque (
    id BIGINT NOT NULL AUTO_INCREMENT,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    data_entrada DATE NOT NULL,

    PRIMARY KEY(id)
)