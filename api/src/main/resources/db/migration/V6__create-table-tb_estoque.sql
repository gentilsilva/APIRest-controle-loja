CREATE TABLE tb_estoque (
    id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,

    PRIMARY KEY(id)
);