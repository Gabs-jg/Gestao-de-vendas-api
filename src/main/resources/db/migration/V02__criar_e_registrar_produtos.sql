CREATE TABLE tb_produto (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    quantidade INTEGER NOT NULL,
    preco_custo DECIMAL(10,2) NOT NULL,
    preco_venda DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(500),
    codigo_categoria BIGINT NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES tb_categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

-- INSERT INTO categoria (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values
-- ('Tecnologia');
