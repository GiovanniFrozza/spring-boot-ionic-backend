package com.giovanniEstudo.cursoMC.Services;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import com.giovanniEstudo.cursoMC.repositories.CategoriaRepository;
import com.giovanniEstudo.cursoMC.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<ClienteEntity> findById(Integer id) {
        Optional<ClienteEntity> cliente = this.repository.findById(id);
        if(cliente == null) {
            throw new ObjetoNaoEncontradoException();
        }
        return cliente;
    }

}
