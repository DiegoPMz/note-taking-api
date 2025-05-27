package io.github.diegopmz.note_taking_api.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.github.diegopmz.note_taking_api.entities.NoteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

    private EntityManager entityManager;

    public NoteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(NoteEntity note) {
        this.entityManager.persist(note);
    }

    @Override
    @Transactional
    public void delete(NoteEntity note) {
        this.entityManager.remove(note);
    }

    @Override
    public List<NoteEntity> getArchivedNotesByUser(int userId) {
        TypedQuery<NoteEntity> query = this.entityManager.createQuery(
                "SELECT n FROM NoteEntity n "
                        + "WHERE n.user.id = :paramUserId AND n.archived = true ",
                NoteEntity.class);
        query.setParameter("paramUserId", userId);
        return query.getResultList();
    }

    @Override
    public NoteEntity findById(int noteId) {
        return this.entityManager.find(NoteEntity.class, noteId);
    }

    // PENDING
    @Override
    public List<NoteEntity> searchNotesByText(String queryText, int userId) {

        TypedQuery<NoteEntity> query = this.entityManager.createNamedQuery(
                "SELECT n FROM NoteEntity n "
                        + "WHERE n.user_id = :paramId AND "
                        + "(n.title LIKE CONCAT('%', :paramQuery, '%') OR "
                        + "n.content LIKE CONCAT('%', :paramQuery, '%'))",
                NoteEntity.class);
        query.setParameter("paramId", userId);
        query.setParameter("paramQuery", queryText);

        return query.getResultList();
    }

    @Override
    public List<NoteEntity> getUnarchivedNotesByUser(int userId) {
        TypedQuery<NoteEntity> query = this.entityManager.createQuery(
                "SELECT n FROM NoteEntity n "
                        + "WHERE n.user.id = :paramUserId",
                NoteEntity.class);
        query.setParameter("paramUserId", userId);
        return query.getResultList();
    }

}
