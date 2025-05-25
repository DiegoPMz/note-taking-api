package io.github.diegopmz.note_taking_api.repositories;

import io.github.diegopmz.note_taking_api.entities.UserEntity;

public interface UserRepository {

    UserEntity save(UserEntity user);

    UserEntity findById(int id);

    void delete(UserEntity user);

    UserEntity userWithNotesByUserId(int userId);

    UserEntity userWithNotesByEmail(String email);
}
