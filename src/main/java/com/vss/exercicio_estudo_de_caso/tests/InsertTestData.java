package com.vss.exercicio_estudo_de_caso.tests;

import com.vss.exercicio_estudo_de_caso.domain.Categoria;
import com.vss.exercicio_estudo_de_caso.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InsertTestData {


    private CategoriaRepository categoriaRepository;

    @Autowired
    public InsertTestData(CategoriaRepository cr ){
        this.categoriaRepository = cr;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");
        Categoria cat3 = new Categoria(null,"Esportes");
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
