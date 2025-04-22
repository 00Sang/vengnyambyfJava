package com.vengnuambyf.lyrics.services;

import com.vengnuambyf.lyrics.entities.Lyrics;
import com.vengnuambyf.lyrics.repositories.LyricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LyricsService {

    private final LyricsRepository lyricsRepository;

    public List<Lyrics> getAllLyrics() {
        return lyricsRepository.findAll();
    }

    public Optional<Lyrics> getLyricsById(Long id) {
        return lyricsRepository.findById(id);
    }

    public Lyrics createLyrics(Lyrics lyrics) {
        return lyricsRepository.save(lyrics);
    }

    public Lyrics updateLyrics(Long id, Lyrics newLyrics) {
        return lyricsRepository.findById(id).map(lyrics -> {
            lyrics.setTitle(newLyrics.getTitle());
            lyrics.setContent(newLyrics.getContent());
            lyrics.setAuthor(newLyrics.getAuthor());
            return lyricsRepository.save(lyrics);
        }).orElseThrow(() -> new RuntimeException("Lyrics not found"));
    }

    public void deleteLyrics(Long id) {
        lyricsRepository.deleteById(id);
    }
}
