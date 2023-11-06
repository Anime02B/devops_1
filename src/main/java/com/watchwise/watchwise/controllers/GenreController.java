package com.watchwise.watchwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.watchwise.watchwise.entities.Genre; // Импортируйте Genre
import com.watchwise.watchwise.services.GenreService; // Импортируйте GenreService

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGenre(@RequestBody Genre genre) {
        Boolean updated = genreService.updateGenre(genre);
        if (updated) {
            return ResponseEntity.ok("Genre updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        Boolean deleted = genreService.deleteGenre(id);
        if (deleted) {
            return ResponseEntity.ok("Genre deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

