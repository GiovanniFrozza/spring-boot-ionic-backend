package com.giovanniEstudo.cursoMC.repositories;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Integer> {

}
