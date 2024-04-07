package com.projeto.ada.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.projeto.ada.model.Produto;
import com.projeto.ada.repository.Repositorio;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@Component
public class DbInit {
    private final Repositorio<Produto> repositorio;

    public DbInit(Repositorio<Produto> repositorio) {
        this.repositorio = repositorio;
    }

    private List<Produto> carregarDadosCsv() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/projeto/ada/db/produtos.csv").toAbsolutePath());
        CsvToBean<Produto> mapper = new CsvToBeanBuilder<Produto>(reader)
                .withType(Produto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return mapper.parse();
    }

    private void alimentarDb(List<Produto> produtos) {
        produtos.forEach(repositorio::salvar);
    }

    public void executar() throws IOException {
        try {
            List<Produto> produtos = carregarDadosCsv();
            alimentarDb(produtos);
            System.out.println("Banco de dados carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Base de dados já está carregada.");
        }
    }
}
