package com.vss.exercicio_estudo_de_caso.repositories;

import com.vss.exercicio_estudo_de_caso.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
