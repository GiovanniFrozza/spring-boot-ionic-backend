package com.giovanniEstudo.cursoMC.Services;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.DataIntegrityException;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import com.giovanniEstudo.cursoMC.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Optional<CategoriaEntity> findById(Integer id) {
        Optional<CategoriaEntity> categoria = this.repository.findById(id);
        if(categoria == null) {
            throw new ObjetoNaoEncontradoException();
        }
        return categoria;
    }

    public CategoriaEntity insert(CategoriaEntity categoriaEntity) {
        categoriaEntity.setId(null);
        return repository.save(categoriaEntity);
    }

    public CategoriaEntity update(CategoriaEntity categoriaEntity) {
        return repository.save(categoriaEntity);
    }

    public void deleteById(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }
        catch( DataIntegrityViolationException e ) {
            throw new DataIntegrityException();
        }
    }

}
