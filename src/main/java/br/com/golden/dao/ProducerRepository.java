package br.com.golden.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.golden.model.Movie;

@Repository
public interface ProducerRepository extends JpaRepository<Movie, Long> {

}
