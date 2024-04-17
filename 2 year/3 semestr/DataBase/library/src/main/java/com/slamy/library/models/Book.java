package com.slamy.library.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Book")
@Table(name = "books")
public class Book {
    @Id
    @Setter
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Setter
    @Getter
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Setter
    @Getter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @JsonIgnore
    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private List<User> users;

    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", author=" + author +
                '}';
    }
}
