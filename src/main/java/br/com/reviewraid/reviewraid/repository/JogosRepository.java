package br.com.reviewraid.reviewraid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reviewraid.reviewraid.model.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long>{
    
}
