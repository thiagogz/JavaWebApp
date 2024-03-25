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
public class Tags {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nome da tag é obrigatória")
    @Size(min = 3, max = 255, message = "O nome da tag deve ter pelo menos 3 caracteres")
    private String nome;

    @Size(min = 3, max = 255, message = "A descrição deve ter pelo menos 3 caracteres")
    private String descricao;
}
