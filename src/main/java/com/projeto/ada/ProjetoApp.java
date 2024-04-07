package com.projeto.ada;

import com.projeto.ada.model.Produto;
import com.projeto.ada.service.DbInit;
import com.projeto.ada.service.ProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ProjetoApp implements CommandLineRunner {
    private final ProdutoService produtoService;
    private final DbInit dbInit;

    public ProjetoApp(ProdutoService produtoService, DbInit dbInit) {
        this.produtoService = produtoService;
        this.dbInit = dbInit;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        dbInit.executar();
        List<Produto> produtos = produtoService.listarProdutos();
        Set<String> categoriasDistintas = produtoService.contarCategoriasDistintas(produtos);
        System.out.printf("Número de categorias distintas: %d%n", categoriasDistintas.size());
        System.out.printf("Categorias: %s%n", categoriasDistintas);

        produtoService.contarProdutosPorCategoria(produtos);
        produtoService.calcularValorMedioProdutos(produtos);
        produtoService.listarProdutosAteVinteUnidades(produtos);
        produtoService.filtrarProdutos(produtos, produto -> produto.getQuantidadeProduto() <= 3);
    }
}
