package io.github.diegopmz.note_taking_api.repositories;

import java.util.List;

import io.github.diegopmz.note_taking_api.entities.NoteEntity;

public interface NoteRepository {

    void save(NoteEntity note);

    void delete(NoteEntity note);

    NoteEntity findById(int noteId);

    List<NoteEntity> getUnarchivedNotesByUser(int userId);

    List<NoteEntity> getArchivedNotesByUser(int userId);

    List<NoteEntity> searchNotesByText(String queryText, int userId);
}
