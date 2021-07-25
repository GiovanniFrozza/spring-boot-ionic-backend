package com.giovanniEstudo.cursoMC.Controllers;

import com.giovanniEstudo.cursoMC.DTO.ClienteDTO;
import com.giovanniEstudo.cursoMC.Entities.ClienteEntity;
import com.giovanniEstudo.cursoMC.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ClienteDTO> findAll() {
        return this.service.findAll();
    }


}
