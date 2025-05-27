package io.github.diegopmz.note_taking_api.repositories;

import org.springframework.stereotype.Repository;

import io.github.diegopmz.note_taking_api.entities.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        this.entityManager.persist(user);
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        return this.entityManager.find(UserEntity.class, id);
    }

    @Override
    @Transactional
    public void delete(UserEntity user) {
        this.entityManager.remove(user);
    }

    @Override
    public UserEntity userWithNotesByUserId(int userId) {
        TypedQuery<UserEntity> query = this.entityManager.createQuery(
                "SELECT u FROM UserEntity u "
                        + "JOIN FETCH u.notes "
                        + "WHERE u.id = :paramId ",
                UserEntity.class);
        query.setParameter("paramId", userId);
        return query.getSingleResult();
    }

    @Override
    public UserEntity userWithNotesByEmail(String email) {
        TypedQuery<UserEntity> query = this.entityManager.createQuery(
                "SELECT u FROM UserEntity u "
                        + "JOIN FETCH u.notes "
                        + "WHERE u.email = :paramEmail ",
                UserEntity.class);
        query.setParameter("paramEmail", email);
        return query.getSingleResult();
    }
}
