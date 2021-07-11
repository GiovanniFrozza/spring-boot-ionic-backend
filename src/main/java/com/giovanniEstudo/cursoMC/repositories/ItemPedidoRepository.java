package com.giovanniEstudo.cursoMC.repositories;

import com.giovanniEstudo.cursoMC.Entities.ItemPedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedidoEntity, Integer> {
}
