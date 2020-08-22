package com.vss.exercicio_estudo_de_caso.tests;

import com.vss.exercicio_estudo_de_caso.domain.Categoria;
import com.vss.exercicio_estudo_de_caso.domain.Produto;
import com.vss.exercicio_estudo_de_caso.repositories.CategoriaRepository;
import com.vss.exercicio_estudo_de_caso.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InsertTestData {


    private CategoriaRepository categoriaRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public InsertTestData(CategoriaRepository cr , ProdutoRepository pr){

        this.categoriaRepository = cr;
        this.produtoRepository =pr;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");
        Categoria cat3 = new Categoria(null,"Esportes");

        Produto p1 = new Produto(null,"Computador",2000.00);
        Produto p2 = new Produto(null,"Impressora",800.00);
        Produto p3 = new Produto(null,"Mouse",20.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
