package com.giovanniEstudo.cursoMC.repositories;

import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
}
