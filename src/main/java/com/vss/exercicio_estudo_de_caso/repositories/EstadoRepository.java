package com.vss.exercicio_estudo_de_caso.repositories;

import com.vss.exercicio_estudo_de_caso.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {
}
