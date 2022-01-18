package com.marcossa.gestaocliente.repository;

import com.marcossa.gestaocliente.domain.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {

    List<Produto> produtos = new ArrayList<>();

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
}
