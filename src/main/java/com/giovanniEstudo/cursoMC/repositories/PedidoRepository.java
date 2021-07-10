package com.giovanniEstudo.cursoMC.repositories;

import com.giovanniEstudo.cursoMC.Entities.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {

}
