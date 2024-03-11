package br.com.reviewraid.reviewraid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// public record Jogos (Long id, String name, String image, String description, String launch_date, String[] tags) {
//     public Jogos(Long id, String name, String image, String description, String launch_date, String[] tags) {
//         var key = (id == null) ? Math.abs(new Random().nextLong()) : id;
//         this.id = key;
//         this.name = name;
//         this.image = image;
//         this.description = description;
//         this.launch_date = launch_date;
//         this.tags = tags;
//     }
//}

@Data
@Entity
public class Jogos extends Object{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String description;
    private String launch_date;
    private String[] tags;

}