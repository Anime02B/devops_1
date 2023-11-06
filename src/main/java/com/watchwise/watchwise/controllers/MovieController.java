package com.watchwise.watchwise.controllers;

import com.watchwise.watchwise.dto.ActorCharacter;
import com.watchwise.watchwise.entities.Movie;
import com.watchwise.watchwise.services.MovieService;
import com.watchwise.watchwise.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        System.out.println(movie);
        try {
            movieService.createMovie(movie);
            return ResponseEntity.ok("Фильм успешно сохранен.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Произошла ошибка при сохранении фильма.");
        }
    }


    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@RequestBody Movie movie) {
        Boolean updated = movieService.updateMovie( movie);
        if (updated) {
            return ResponseEntity.ok("Movie updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        Boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return ResponseEntity.ok("Movie deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/roles")
    public List<ActorCharacter> getRolesForMovie(@PathVariable Long id) {
        List<ActorCharacter> roles = roleService.findRolesByMovieIdWithActors(id);
        return roles;
    }
}

