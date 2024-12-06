package com.antilob.engine.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Challenge")
public class Challenge {

    @Id
    @org.springframework.data.annotation.Id
    private long id;
    @Column(name = "nom_challenge")
    private String name;


    @Column(name = "abbreviation")
    private String shortname;


/*    @OneToMany(mappedBy = "challenge")
    private Collection<Race> race;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return id == challenge.id && Objects.equals(name, challenge.name) && Objects.equals(shortname, challenge.shortname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname);
    }
}
