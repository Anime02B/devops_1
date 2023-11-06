package com.watchwise.watchwise.repositories;

import com.watchwise.watchwise.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MovieJPARepository extends JpaRepository<Movie, Long> {

}
