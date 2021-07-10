package com.giovanniEstudo.cursoMC.repositories;

import com.giovanniEstudo.cursoMC.Entities.PagamentoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends CrudRepository<PagamentoEntity, Integer> {
}
