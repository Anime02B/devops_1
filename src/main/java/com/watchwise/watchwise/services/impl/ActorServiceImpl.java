package com.watchwise.watchwise.services.impl;

import com.watchwise.watchwise.entities.Actor;
import com.watchwise.watchwise.repositories.ActorRepository;
import com.watchwise.watchwise.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateActor(Actor actor) {
        Actor existingActor = actorRepository.findById(actor.getId()).orElse(null);
        if (existingActor != null) {
            actorRepository.save(actor);
            System.out.println("OK updateActor");
            return true;
        } else {
            System.out.println("Error updateActor");
            return false;
        }
    }

    @Override
    public Boolean deleteActor(Long id) {
        Actor existingActor = actorRepository.findById(id).orElse(null);
        if (existingActor != null) {
            actorRepository.deleteById(id);
            System.out.println("OK deleteActor");
            return true;
        } else {
            System.out.println("Error deleteActor");
            return false;
        }
    }
}
