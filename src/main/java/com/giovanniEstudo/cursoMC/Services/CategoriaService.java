package com.giovanniEstudo.cursoMC.Services;

import com.giovanniEstudo.cursoMC.DTO.CategoriaDTO;
import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.DataIntegrityException;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import com.giovanniEstudo.cursoMC.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<CategoriaDTO> findAll() {
        List<CategoriaEntity> categorias = (List<CategoriaEntity>) this.repository.findAll();
        return this.converteLista(categorias);
    }

    private List<CategoriaDTO> converteLista( List<CategoriaEntity> categorias ) {
        ArrayList<CategoriaDTO> listaCategorias = new ArrayList<>();
        for(CategoriaEntity categoria : categorias ) {
            listaCategorias.add( new CategoriaDTO( categoria ) );
        }
        return listaCategorias;
    }

    /*
    public Page<CategoriaEntity> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
     */

}
