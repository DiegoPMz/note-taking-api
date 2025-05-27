package io.github.diegopmz.note_taking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.diegopmz.note_taking_api.entities.NoteEntity;
import io.github.diegopmz.note_taking_api.entities.TagEntity;
import io.github.diegopmz.note_taking_api.repositories.NoteRepository;
import io.github.diegopmz.note_taking_api.repositories.TagRepository;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private TagRepository tagRepository;

    public NoteService(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    public Optional<NoteEntity> createNote(NoteEntity noteData) {
        this.noteRepository.save(noteData);
        return Optional.ofNullable(noteData);
    }

    public Optional<List<NoteEntity>> getUnarchivedNotes(int userId) {
        List<NoteEntity> notes = this.noteRepository.getUnarchivedNotesByUser(userId);
        return Optional.ofNullable(notes);
    }

    public Optional<List<NoteEntity>> getArchivedNotes(int userId) {
        List<NoteEntity> notes = this.noteRepository.getArchivedNotesByUser(userId);
        return Optional.ofNullable(notes);
    }

    public Optional<List<TagEntity>> getAllTags(int userId) {
        List<TagEntity> userTags = this.tagRepository.findAllByUserId(userId);
        return Optional.ofNullable(userTags);
    }

    public Optional<TagEntity> createTag(TagEntity noteData) {
         TagEntity newTag = this.tagRepository.save(noteData);
        return Optional.ofNullable(newTag);
    }

}
