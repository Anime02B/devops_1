package com.watchwise.watchwise.services;

import com.watchwise.watchwise.entities.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Boolean updateMovie(Movie movie);
    Boolean deleteMovie(Long id);

}
