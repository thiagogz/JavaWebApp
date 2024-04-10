package br.com.reviewraid.reviewraid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Jogos extends Object{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message =  "{jogos.nome.notblank}")
    @Size(min = 3, max = 50, message = "{jogos.nome.size}")
    private String name;

    @NotBlank(message =  "{jogos.image.notblank}")
    private String image;

    @NotBlank(message =  "{jogos.description.notblank}")
    @Size(min = 3, max = 500, message = "{jogos.description.size}")
    private String description;

    @NotBlank(message =  "{jogos.date.notblank}")
    private String launch_date;

    private String[] tags;

}