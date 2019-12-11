package br.com.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import br.com.trabalhofinal.model.Produto;

public interface ProdutoService {

    List < Produto > findAll();

    void save(Produto Produto);

    Optional < Produto > findById(Long id);

    void delete(long id);
}