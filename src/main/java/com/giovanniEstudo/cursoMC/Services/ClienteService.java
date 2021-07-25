package com.giovanniEstudo.cursoMC.Services;

import com.giovanniEstudo.cursoMC.DTO.ClienteDTO;
import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.DataIntegrityException;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import com.giovanniEstudo.cursoMC.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void deleteById(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }
        catch( DataIntegrityViolationException e ) {
            throw new DataIntegrityException();
        }
    }

    public List<ClienteDTO> findAll() {
        List<ClienteEntity> clientes = (List<ClienteEntity>) this.repository.findAll();
        return this.converteLista(clientes);
    }

    private List<ClienteDTO> converteLista( List<ClienteEntity> clientes ) {
        ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
        for(ClienteEntity cliente : clientes ) {
            listaClientes.add( new ClienteDTO( cliente ) );
        }
        return listaClientes;
    }

    public ClienteEntity fromDTO(ClienteDTO clienteDTO) {
        return new ClienteEntity(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }

}
