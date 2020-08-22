package com.vss.exercicio_estudo_de_caso.services;

import com.vss.exercicio_estudo_de_caso.domain.Categoria;
import com.vss.exercicio_estudo_de_caso.repositories.CategoriaRepository;
import com.vss.exercicio_estudo_de_caso.services.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> categoria =  categoriaRepository.findById(id);
        return categoria.orElseThrow(()-> new ObjectNotFoundException(
                    "Objeto nao encotrado! ID:"+id+", Tipo: "+Categoria.class.getName()
                ));
    }

    public List<Categoria> findAll(){
        List<Categoria> listCategorias = categoriaRepository.findAll();
        return listCategorias;
    }
}
