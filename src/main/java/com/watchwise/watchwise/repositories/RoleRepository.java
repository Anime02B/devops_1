package com.watchwise.watchwise.repositories;

import com.watchwise.watchwise.dto.ActorCharacter;
import com.watchwise.watchwise.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT new com.watchwise.watchwise.dto.ActorCharacter(CONCAT(a.lastName, ' ', a.firstName), r.characterName) " +
            "FROM Role r " +
            "JOIN r.actor a " +
            "WHERE r.movie.id = :movieId")
    List<ActorCharacter> findActorsAndCharactersByMovieId(@Param("movieId") Long movieId);
}
