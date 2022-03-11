package com.attractor.lesson_49.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor

public class Candidate {

    public static final Candidate EMPTY = new Candidate("Anon Y Mouse", "anon.jpg");

    @Id
    private String id;

    private String name;
    private String photo;
    private int votes = 0;

    public Candidate(String name, String photo) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(photo);
        this.id = String.valueOf(name.hashCode()); //UUID.randomUUID().toString();
        this.name = name;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", votes=" + votes +
                '}';
    }

    public void vote() {
        setVotes(getVotes() + 1);
    }
}
