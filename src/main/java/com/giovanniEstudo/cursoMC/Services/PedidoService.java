package com.giovanniEstudo.cursoMC.Services;

import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import com.giovanniEstudo.cursoMC.Entities.PedidoEntity;
import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import com.giovanniEstudo.cursoMC.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Optional<PedidoEntity> findById(Integer id) {
        Optional<PedidoEntity> pedido = this.repository.findById(id);
        if(pedido == null) {
            throw new ObjetoNaoEncontradoException();
        }
        return pedido;
    }

}
