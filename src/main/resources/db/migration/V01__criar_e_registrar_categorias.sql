CREATE TABLE tb_categoria (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO tb_categoria (nome) values ('Tecnologia');
INSERT INTO tb_categoria (nome) values ('Acessórios para veículos');
INSERT INTO tb_categoria (nome) values ('Esporte e Lazer');
INSERT INTO tb_categoria (nome) values ('Casa e Eletrodomésticos');
INSERT INTO tb_categoria (nome) values ('Joias e Relógio');