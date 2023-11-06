package com.watchwise.watchwise.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Column(name = "budget")
    private Long budget;

    @Column(name = "duration", nullable = false, columnDefinition = "interval")
    private int duration;

//, @Column(columnDefinition = "interval")

//    @Column(name = "duration", nullable = false) //, columnDefinition = "interval"
//    private Duration duration; // Изменен тип на long

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();








//    public void setDuration(int durationInMinutes) {
//        this.duration = Duration.ofMinutes(durationInMinutes);
//    }
//
//    public Movie(Long id, String title, int releaseYear, Long budget, int durationInMinutes, Set<Genre> genres) {
//        this.id = id;
//        this.title = title;
//        this.releaseYear = releaseYear;
//        this.budget = budget;
//        this.duration = Duration.ofMinutes(durationInMinutes);
//        this.genres = genres;
//    }


}

