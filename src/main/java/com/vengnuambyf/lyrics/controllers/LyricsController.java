package com.vengnuambyf.lyrics.controllers;

import com.vengnuambyf.lyrics.entities.Lyrics;
import com.vengnuambyf.lyrics.services.LyricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LyricsController {

    private final LyricsService lyricsService;

    // GET /lyrics - Get all lyrics
    @GetMapping("/getAll")
    public ResponseEntity<List<Lyrics>> getAllLyrics() {
        List<Lyrics> lyrics = lyricsService.getAllLyrics();
        return ResponseEntity.ok(lyrics);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getLyrics(@PathVariable Long id) {
        // Using Optional to check if lyrics are found
        return lyricsService.getLyricsById(id)
                .map(lyrics -> ResponseEntity.ok((Object) lyrics))
                .orElseGet(() -> ResponseEntity.status(404).body("Lyrics not found"));
    }

    // POST /lyrics - Add new lyrics
    @PostMapping("/add")
    public ResponseEntity<?> addNewLyrics(@RequestBody Lyrics lyrics) {
        try {
            // If no author provided, set it to empty string
            if (lyrics.getAuthor() == null) {
                lyrics.setAuthor(""); // Set author to empty string if null
            }
            Lyrics newLyrics = lyricsService.createLyrics(lyrics);
            return ResponseEntity.status(201).body(newLyrics); // Return 201 with the created lyrics
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the lyrics.");
        }
    }

    // PUT /lyrics/{id} - Update lyrics
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLyrics(@PathVariable Long id, @RequestBody Lyrics newLyrics) {
        try {
            Lyrics updated = lyricsService.updateLyrics(id, newLyrics);
            return ResponseEntity.ok(updated); // Return the updated lyrics
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Lyrics not found"); // Handle not found error
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while updating the lyrics.");
        }
    }

    // DELETE /lyrics/{id} - Delete lyrics
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLyrics(@PathVariable Long id) {
        try {
            lyricsService.deleteLyrics(id); // Delete the lyrics by ID
            return ResponseEntity.ok("Lyrics deleted successfully."); // Success response
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Lyrics not found"); // Handle not found error
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while deleting the lyrics.");
        }
    }
}
