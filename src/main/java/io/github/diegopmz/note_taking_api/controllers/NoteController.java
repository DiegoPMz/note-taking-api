package io.github.diegopmz.note_taking_api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.diegopmz.note_taking_api.entities.NoteEntity;
import io.github.diegopmz.note_taking_api.entities.TagEntity;

@RestController
@RequestMapping(name = "/api")
public class NoteController {

    @GetMapping("/notes")
    public ResponseEntity<List<NoteEntity>> getNotes() {
        return null;
    }

    @PostMapping("/notes")
    public ResponseEntity<List<NoteEntity>> createNote(@RequestBody NoteEntity note) {
        return null;
    }

    @PatchMapping("/notes/{noteId}")
    public ResponseEntity<NoteEntity> updateNote(
            @PathVariable Long noteId,
            @RequestBody NoteEntity noteUpdated) {
        return null;
    }

    @GetMapping("/notes/archived")
    public ResponseEntity<List<NoteEntity>> getArchivedNotes() {
        return null;
    }

    @GetMapping("/notes/tags")
    public ResponseEntity<List<TagEntity>> getAllTags() {
        return null;
    }

    @PostMapping("/notes/tags")
    public ResponseEntity<TagEntity> createTag(@RequestBody TagEntity tag) {
        return null;
    }
}
