package com.giovanniEstudo.cursoMC.resources;

import com.giovanniEstudo.cursoMC.domain.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {

        Categoria categoria = new Categoria(1, "Informatica");
        Categoria categoria2 = new Categoria(2, "Escritorio");

        List<Categoria> lista = new ArrayList<>();
        lista.add(categoria);
        lista.add(categoria2);

        return lista;
    }
}


