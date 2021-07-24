package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.DTO.CategoriaDTO;
import com.giovanniEstudo.cursoMC.Services.CategoriaService;
import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody CategoriaEntity categoriaEntity, @PathVariable Integer id) {
        categoriaEntity = service.update(categoriaEntity);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoriaDTO> findAll() {
        return this.service.findAll();
    }

    /*
    @RequestMapping(value = "/retornaTodas", method = RequestMethod.GET)
    public Page<CategoriaEntity> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction ) {
        return this.service.findPage(page, linesPerPage, orderBy, direction);
    }
     */

}


