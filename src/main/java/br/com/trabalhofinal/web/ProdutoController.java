package br.com.trabalhofinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.model.Produto;
import br.com.trabalhofinal.repository.ProdutoRepository;

@CrossOrigin
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> getTodosProdutos(){
        return this.produtoRepository.findAll();
    }
    
}

