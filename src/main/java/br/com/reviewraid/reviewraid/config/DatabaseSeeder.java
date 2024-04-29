package br.com.reviewraid.reviewraid.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.reviewraid.reviewraid.model.Categoria;
import br.com.reviewraid.reviewraid.model.Jogos;
import br.com.reviewraid.reviewraid.repository.CategoriaRepository;
import br.com.reviewraid.reviewraid.repository.JogosRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    JogosRepository jogosRepository;

    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.saveAll(
            List.of(
                Categoria.builder().id(1L).nome("Singleplayer").descricao("Jogos que podem ser jogados sozinho, sem a necessidade de outras pessoas.").tipo("TAG").icone("user").build(),
                Categoria.builder().id(2L).nome("Multiplayer").descricao("Jogos que podem ser jogados com mais de uma pessoa, seja online ou localmente.").tipo("TAG").icone("users").build(),
                Categoria.builder().id(3L).nome("Ação").descricao("Jogos que envolvem muita ação, combate e movimentação rápida.").tipo("TAG").icone("flame").build(),
                Categoria.builder().id(4L).nome("Aventura").descricao("Jogos que envolvem exploração, descoberta e narrativa.").tipo("TAG").icone("pawprint").build(),
                Categoria.builder().id(5L).nome("RPG").descricao("Jogos que envolvem estratégias, evolução de personagens e narrativa rica.").tipo("TAG").icone("sparkle").build(),
                Categoria.builder().id(6L).nome("Corrida").descricao("Jogos que envolvem competição de velocidade, seja em carros, motos ou outros veículos.").tipo("TAG").icone("medal").build(),
                Categoria.builder().id(7L).nome("Plataforma").descricao("Jogos que envolvem pulos, saltos e desafios de plataforma.").tipo("TAG").icone("crown").build()
            )
        );
        
        jogosRepository.saveAll(
            List.of(
                Jogos.builder()
                    .id(1L)
                    .name("Baldur's Gate 3")
                    .image("baldurs_gate_3.jpg")
                    .description("Game of the Year de 2023, Baldur's Gate 3 é um RPG de ação e aventura que promete muitas horas de diversão e desafios. Com gráficos incríveis e uma história envolvente, o jogo é uma ótima pedida para quem gosta de jogos de RPG.")
                    .launch_date("03/10/2023")
                    .categoria(categoriaRepository.findById(5L).get())
                    .build(),
                Jogos.builder()
                    .id(2L)
                    .name("It Takes Two")
                    .image("it_takes_two.jpg")
                    .description("Com uma proposta inovadora e divertida, It Takes Two é um jogo cooperativo que exige trabalho em equipe e muita comunicação. Com gráficos incríveis e uma história envolvente, o jogo é uma ótima pedida para quem gosta de jogos multiplayer.")
                    .launch_date("25/03/2021")
                    .categoria(categoriaRepository.findById(2L).get())
                    .build(),
                Jogos.builder()
                    .id(3L)
                    .name("God of War: Ragnarok")
                    .image("god_of_war_ragnarok.jpg")
                    .description("Tendo como pano de fundo a mitologia nórdica, God of War: Ragnarok é um jogo de ação e aventura que promete muitas horas de diversão e desafios. Com gráficos incríveis e uma história envolvente, o jogo é uma ótima pedida para quem gosta de jogos de ação.")
                    .launch_date("09/11/2022")
                    .categoria(categoriaRepository.findById(3L).get())
                    .build()
            )
        );
    }
    
}
