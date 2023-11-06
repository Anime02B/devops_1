package com.watchwise.watchwise.repositories;

import com.watchwise.watchwise.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
