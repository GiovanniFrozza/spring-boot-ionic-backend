package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.Services.CategoriaService;
import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody CategoriaEntity categoriaEntity) {
        categoriaEntity = service.insert(categoriaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}


