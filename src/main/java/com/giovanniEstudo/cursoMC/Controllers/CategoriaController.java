package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.Services.CategoriaService;
import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<CategoriaEntity> findById(@PathVariable Integer id) {
        return this.service.findById(id);
    }
}


