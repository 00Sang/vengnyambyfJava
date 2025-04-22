package com.vengnuambyf.lyrics.runners;

import com.vengnuambyf.lyrics.entities.Lyrics;
import com.vengnuambyf.lyrics.repositories.LyricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseTestRunner implements CommandLineRunner {

    private final LyricsRepository lyricsRepository;

    @Override
    public void run(String... args) {
        try {
            long count = lyricsRepository.count();
            System.out.println("✅ Successfully connected to the database. Lyrics count: " + count);
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to the database: " + e.getMessage());
        }
    }
}
