package io.github.diegopmz.note_taking_api.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.diegopmz.note_taking_api.entities.TagEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class TagRepositoryImpl implements TagRepository {

    private EntityManager entityManager;

    @Autowired
    public TagRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TagEntity findByName(String tagName) {
        TypedQuery<TagEntity> query = this.entityManager.createQuery(
                "SELECT t FROM TagEntity t WHERE t.name = :paramName",
                TagEntity.class);

        query.setParameter("paramName", tagName);
        return query.getSingleResult();
    }

    @Override
    public List<TagEntity> findAllByUserId(int userId) {
        TypedQuery<TagEntity> query = this.entityManager.createQuery(
                "SELECT DISTINCT t.tags FROM NoteEntity n "
                        + " JOIN n.tags t "
                        + " WHERE n.userId = :paramUserId ",
                TagEntity.class);

        query.setParameter("paramUserId", userId);
        return query.getResultList();
    }

}
