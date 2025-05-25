package io.github.diegopmz.note_taking_api.repositories;

import java.util.List;

import io.github.diegopmz.note_taking_api.entities.TagEntity;

public interface TagRepository {

    TagEntity findByName(String tagName);

    List<TagEntity> findAllByUserId(int userId);
}
