package com.vss.exercicio_estudo_de_caso.tests;

import com.vss.exercicio_estudo_de_caso.domain.Categoria;
import com.vss.exercicio_estudo_de_caso.domain.Cidade;
import com.vss.exercicio_estudo_de_caso.domain.Estado;
import com.vss.exercicio_estudo_de_caso.domain.Produto;
import com.vss.exercicio_estudo_de_caso.repositories.CategoriaRepository;
import com.vss.exercicio_estudo_de_caso.repositories.CidadeRepository;
import com.vss.exercicio_estudo_de_caso.repositories.EstadoRepository;
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
    private CidadeRepository cidadeRepository;
    private EstadoRepository estadoRepository;

    @Autowired
    public InsertTestData(CategoriaRepository categoriaRepository ,
                          ProdutoRepository produtoRepository,
                          CidadeRepository cidadeRepository,
                          EstadoRepository estadoRepository){

        this.categoriaRepository = categoriaRepository;
        this.produtoRepository =produtoRepository;
        this.cidadeRepository=cidadeRepository;
        this.estadoRepository=estadoRepository;

    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");
        Categoria cat3 = new Categoria(null,"Esportes");

        Produto p1 = new Produto(null,"Computador",2000.00);
        Produto p2 = new Produto(null,"Impressora",800.00);
        Produto p3 = new Produto(null,"Mouse",20.00);

        Estado estado1 = new Estado(null,"Minas Gerais");
        Estado estado2 = new Estado(null,"São Paulo");

        Cidade c1 = new Cidade(null,"Uberlandia",estado1);
        Cidade c2 = new Cidade(null,"São Paulo",estado2);
        Cidade c3 = new Cidade (null,"Campinas",estado2);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        estado1.getCidades().addAll(Arrays.asList(c1));
        estado2.getCidades().addAll(Arrays.asList(c2,c3));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
        estadoRepository.saveAll(Arrays.asList(estado1,estado2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));



    }
}
