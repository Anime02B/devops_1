package com.watchwise.watchwise.controllers;

import com.watchwise.watchwise.entities.Actor;
import com.watchwise.watchwise.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor createdActor = actorService.createActor(actor);
        return ResponseEntity.ok(createdActor);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getAllActors();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Actor actor = actorService.getActorById(id);
        if (actor != null) {
            return ResponseEntity.ok(actor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateActor(@RequestBody Actor actor) {
        Boolean result = actorService.updateActor(actor);
        if (result) {
            return ResponseEntity.ok("Actor updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        Boolean result = actorService.deleteActor(id);
        if (result) {
            return ResponseEntity.ok("Actor deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
