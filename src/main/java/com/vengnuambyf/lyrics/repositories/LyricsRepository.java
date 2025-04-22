package com.vengnuambyf.lyrics.repositories;

import com.vengnuambyf.lyrics.entities.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
    // You can add custom query methods here, for example:
    // List<Lyrics> findByAuthor(String author);
}
