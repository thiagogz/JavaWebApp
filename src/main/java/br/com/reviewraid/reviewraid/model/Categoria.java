package br.com.reviewraid.reviewraid.model;

import br.com.reviewraid.reviewraid.validation.TipoTags;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Categoria extends Object{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message =  "{tags.nome.notblank}")
    @Size(min = 3, max = 255, message = "{tags.nome.size}")
    private String nome;

    @Size(min = 3, max = 255, message = "erro")
    private String descricao;

    @TipoTags
    private String tipo;

    private String icone;
}
