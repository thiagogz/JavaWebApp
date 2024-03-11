package br.com.reviewraid.reviewraid.model;

import java.util.Random;

public record Jogos (Long id, String nome, String image, String description, String launch_date, String[] tags) {
    public Jogos(Long id, String nome, String image, String description, String launch_date, String[] tags) {
        var key = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.id = key;
        this.nome = nome;
        this.image = image;
        this.description = description;
        this.launch_date = launch_date;
        this.tags = tags;
    }
}