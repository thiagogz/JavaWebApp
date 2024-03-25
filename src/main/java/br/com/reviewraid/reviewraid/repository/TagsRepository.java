package br.com.reviewraid.reviewraid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reviewraid.reviewraid.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long>{

}
