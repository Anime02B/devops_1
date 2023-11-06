package com.watchwise.watchwise.services;

import com.watchwise.watchwise.entities.Genre;

import java.util.List;

public interface GenreService {
    Genre createGenre(Genre genre);
    List<Genre> getAllGenres();
    Genre getGenreById(Long id);
    Boolean updateGenre(Genre genre);
    Boolean deleteGenre(Long id);
}
