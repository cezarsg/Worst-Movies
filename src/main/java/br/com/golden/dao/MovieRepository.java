package br.com.golden.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.golden.model.Movie;

@Repository
@Component("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
