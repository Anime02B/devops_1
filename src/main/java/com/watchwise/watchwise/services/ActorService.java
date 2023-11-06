package com.watchwise.watchwise.services;

import com.watchwise.watchwise.entities.Actor;

import java.util.List;

public interface ActorService {
    Actor createActor(Actor actor);
    List<Actor> getAllActors();
    Actor getActorById(Long id);
    Boolean updateActor(Actor actor);
    Boolean deleteActor(Long id);
}
