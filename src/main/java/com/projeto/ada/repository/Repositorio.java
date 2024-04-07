package com.projeto.ada.repository;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();
    void salvar(T t);
}
