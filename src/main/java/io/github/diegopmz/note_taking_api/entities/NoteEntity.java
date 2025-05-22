package io.github.diegopmz.note_taking_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "updated_at", nullable = false )
    private String updatedAt;

    @Column(name = "archived")
    private boolean archived = false;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "note_tags",
            joinColumns= @JoinColumn(name="note_id"),
            inverseJoinColumns= @JoinColumn(name="tag_id")
    )
    private List<TagEntity> tags;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.DETACH
    })
    @JoinColumn(name = "user_id")
    private UserEntity userDetails;
}
