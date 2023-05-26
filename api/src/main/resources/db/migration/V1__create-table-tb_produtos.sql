CREATE TABLE tb_produtos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,

    PRIMARY KEY(id)
);