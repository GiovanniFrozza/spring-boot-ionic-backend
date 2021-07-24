package com.giovanniEstudo.cursoMC.DTO;

import com.giovanniEstudo.cursoMC.Entities.CategoriaEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min=5, max=80, message = "O tamanho deve ser entre 5 a 80 caracteres")
    private String nome;

    public CategoriaDTO() {

    }

    public CategoriaDTO(CategoriaEntity categoriaEntity) {
        id = categoriaEntity.getId();
        nome = categoriaEntity.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
