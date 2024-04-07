use projeto_santander_coders;

CREATE TABLE IF NOT EXISTS produtos (
    id_produto INTEGER,
    nome_produto VARCHAR(255) NOT NULL,
    quantidade_produto INTEGER NOT NULL,
    categoria_produto VARCHAR(255) NOT NULL,
    preco_produto DECIMAL(8,2) NOT NULL,
    PRIMARY KEY(id_produto)
) ENGINE=INNODB;