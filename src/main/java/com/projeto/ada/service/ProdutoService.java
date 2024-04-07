package com.projeto.ada.service;

import com.projeto.ada.model.Produto;
import com.projeto.ada.repository.Repositorio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final Repositorio<Produto> repositorio;

    public ProdutoService(Repositorio<Produto> repositorio) {
        this.repositorio = repositorio;
    }

    @PostConstruct
    public List<Produto> listarProdutos() {
        return repositorio.listar();
    }
    public Set<String> contarCategoriasDistintas(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto::getCategoriaProduto)
                .collect(Collectors.toSet());
    }
    public void contarProdutosPorCategoria(List<Produto> produtos) {
        Map<String, List<Produto>> produtosPorCategoria = new HashMap<>();
        Set<String> categorias = contarCategoriasDistintas(produtos);
        categorias.forEach(categoria -> produtosPorCategoria.put(categoria, new ArrayList<>()));
        produtos.forEach(produto -> produtosPorCategoria.get(produto.getCategoriaProduto()).add(produto));
        System.out.printf("%n%s%n", "Produtos por Categoria");
        produtosPorCategoria.forEach((key, value) -> System.out.printf("%s -> %d produtos%n", key, value.size()));
    }
    public void calcularValorMedioProdutos(List<Produto> produtos) {
        BigDecimal valorTotal = produtos.stream().map(Produto::getPrecoProduto).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal mediaPrecos = valorTotal.divide(BigDecimal.valueOf(produtos.size()), RoundingMode.HALF_UP);
        System.out.printf("%nPreço médio dos produtos: R$%.2f%n", mediaPrecos);
    }
    public void listarProdutosAteVinteUnidades(List<Produto> produtos) {
        List<Produto> ateTresUnidades = produtos.stream().filter(produto -> produto.getQuantidadeProduto() <= 20).toList();
        System.out.printf("%nLista de produtos até 20 unidades: %s%n", ateTresUnidades);
    }

    public void filtrarProdutos(List<Produto> produtos, Predicate<Produto> predicate) {
        List<Produto> ateTresUnidades = produtos.stream().filter(predicate).toList();
        System.out.printf("%nLista de produtos filtrados: %s%n", ateTresUnidades);
    }
}
