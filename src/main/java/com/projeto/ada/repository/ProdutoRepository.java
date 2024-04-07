package com.projeto.ada.repository;

import com.projeto.ada.model.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository implements Repositorio<Produto>{
    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Produto> listar() {
        String sql = "SELECT * FROM produtos";
        RowMapper<Produto> mapper = ((rs, rowNum) -> new Produto(
                rs.getLong("id_produto"),
                rs.getString("nome_produto"),
                rs.getInt("quantidade_produto"),
                rs.getString("categoria_produto"),
                rs.getBigDecimal("preco_produto")
        ));

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (id_produto, nome_produto, quantidade_produto, categoria_produto, preco_produto) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getQuantidadeProduto(),
                produto.getCategoriaProduto(),
                produto.getPrecoProduto());
    }
}
