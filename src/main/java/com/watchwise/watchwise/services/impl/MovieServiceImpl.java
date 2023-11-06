package com.watchwise.watchwise.services.impl;

import com.watchwise.watchwise.entities.Movie;
import com.watchwise.watchwise.repositories.MovieJPARepository;
import com.watchwise.watchwise.repositories.MovieRepository;
import com.watchwise.watchwise.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieJPARepository movieJPARepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.insertMovie(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieJPARepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieJPARepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateMovie(Movie movie) {
        Movie existingMovie = movieJPARepository.findById(movie.getId()).orElse(null);
        if (existingMovie != null) {
            movieJPARepository.save(movie);
            System.out.println("OK updateMovie");
            return true;
        } else {
            System.out.println("Error updateMovie");
            return false;
        }
    }

    @Override
    public Boolean deleteMovie(Long id) {
        Movie existingMovie = movieJPARepository.findById(id).orElse(null);
        if (existingMovie != null) {
            movieJPARepository.deleteById(id);
            System.out.println("OK deleteMovie");
            return true;
        } else {
            System.out.println("Error deleteMovie");
            return false;
        }
    }
}
