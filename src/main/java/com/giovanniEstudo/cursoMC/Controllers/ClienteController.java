package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import com.giovanniEstudo.cursoMC.Services.CategoriaService;
import com.giovanniEstudo.cursoMC.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ClienteEntity> findById(@PathVariable Integer id) {
        return this.service.findById(id);
    }

}
