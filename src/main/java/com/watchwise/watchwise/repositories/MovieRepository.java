package com.watchwise.watchwise.repositories;

import com.watchwise.watchwise.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public Movie insertMovie(Movie movie) {
        String sql = "INSERT INTO movies (budget, duration, release_year, title) " +
                " VALUES (?, make_interval(?), ?, ?)"; // mins :=

        jdbcTemplate.update(
                sql,
                movie.getBudget(),
                movie.getDuration(),
                movie.getReleaseYear(),
                movie.getTitle()
        );
        movie.setId(jdbcTemplate.queryForObject(sql, Long.class, movie.getTitle(), movie.getReleaseYear(), movie.getBudget(), movie.getDuration()));
        return movie;
    }


//    @Transactional
//    public Movie insertMovie(Movie movie) {
//        String sql = "INSERT INTO public.movies (title, release_year, budget, duration) VALUES (?, ?, ?, ?::interval)";
//        jdbcTemplate.update(sql, movie.getTitle(), movie.getReleaseYear(), movie.getBudget(), movie.getDurationInMinutes());
//        movie.setId(jdbcTemplate.queryForObject(sql, Long.class, movie.getTitle(), movie.getReleaseYear(), movie.getBudget(), movie.getDurationInMinutes()));
//        return movie;
//    }
}

