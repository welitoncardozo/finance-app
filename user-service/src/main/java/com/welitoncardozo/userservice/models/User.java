package com.welitoncardozo.userservice.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@EqualsAndHashCode(of = {"id"})
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(sequenceName = "users_id_seq", name = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "users_id_seq")
    private Integer id;
    private String name;
    private String email;

    @Column(name = "last_change")
    private LocalDateTime lastChange;

    public User preSave() {
        lastChange = LocalDateTime.now();
        return this;
    }

    @Getter
    @Builder
    public static class Dto {
        private final String name;
        private final String email;

        public static Dto from(final User user) {
            return Dto.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
        }
    }
}
