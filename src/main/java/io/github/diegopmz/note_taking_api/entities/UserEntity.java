package io.github.diegopmz.note_taking_api.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "email" )
    private String email;

    @Column(name = "password" )
    private String password;

    @Column(name = "font")
    private String fontSelected;

    @Column(name = "theme")
    private String themeSelected;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "userDetails"
    )
    private List<NoteEntity> notes;
}