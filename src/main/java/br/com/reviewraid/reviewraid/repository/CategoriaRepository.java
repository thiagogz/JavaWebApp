package br.com.reviewraid.reviewraid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reviewraid.reviewraid.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
