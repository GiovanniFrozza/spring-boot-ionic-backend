package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.Entities.PedidoEntity;
import com.giovanniEstudo.cursoMC.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<PedidoEntity> findById(@PathVariable Integer id) {
        return this.service.findById(id);
    }

}
