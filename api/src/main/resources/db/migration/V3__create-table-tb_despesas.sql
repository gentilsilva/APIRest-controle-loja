CREATE TABLE tb_despesas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao TEXT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_despesa DATE NOT NULL,
    ativo TINYINT NOT NULL,

    PRIMARY KEY(id)
);