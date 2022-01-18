package com.marcossa.gestaocliente.service;

import com.marcossa.gestaocliente.domain.Produto;
import com.marcossa.gestaocliente.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto insert(Produto produto) {
        produto.setId(setarId());
        repository.adicionarProduto(produto);
        return produto;
    }

    public List<Produto> listarProdutos() {
        List<Produto> list = repository.listarProdutos();
        return list;
    }

    public Produto buscarPorId(Integer id) {
        Optional<Produto> produto = repository.listarProdutos().stream().filter(x -> x.getId().equals(id)).findFirst();
        return produto.orElse(null);
    }

    public Integer setarId() {
        Integer maior = 0;
        for (Produto p : repository.listarProdutos()) {
            if(p.getId() > maior) {
                maior = p.getId();
            }
        }
        return maior + 1;
    }
}
