package br.com.reviewraid.reviewraid.model;

import br.com.reviewraid.reviewraid.validation.TipoTags;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria extends Object{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message =  "{categorias.nome.notblank}")
    @Size(min = 3, max = 255, message = "{categorias.nome.size}")
    private String nome;

    @Size(min = 3, max = 255, message = "erro")
    private String descricao;

    @TipoTags
    @NotBlank(message = "{categorias.tipo.notblank}")
    private String tipo;

    @NotBlank(message = "{categorias.icone.notblank}")
    private String icone;
}
