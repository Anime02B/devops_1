package com.watchwise.watchwise.services.impl;

import com.watchwise.watchwise.entities.Genre;
import com.watchwise.watchwise.repositories.GenreRepository;
import com.watchwise.watchwise.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateGenre(Genre genre) {
        Genre existingGenre = genreRepository.findById(genre.getId()).orElse(null);
        if (existingGenre != null) {
            genreRepository.save(genre);
            System.out.println("OK updateGenre");
            return true;
        } else {
            System.out.println("Error updateGenre");
            return false;
        }
    }

    @Override
    public Boolean deleteGenre(Long id) {
        Genre existingGenre = genreRepository.findById(id).orElse(null);
        if (existingGenre != null) {
            genreRepository.deleteById(id);
            System.out.println("OK deleteGenre");
            return true;
        } else {
            System.out.println("Error deleteGenre");
            return false;
        }
    }
}
