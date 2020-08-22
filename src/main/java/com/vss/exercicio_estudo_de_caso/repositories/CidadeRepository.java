package com.vss.exercicio_estudo_de_caso.repositories;

import com.vss.exercicio_estudo_de_caso.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
