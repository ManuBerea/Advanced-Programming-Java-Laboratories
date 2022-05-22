package com.example.rest.SocialNetwork;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "socialnetwork")
public class Person {
    @Id
    @Basic
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "FRIENDS")
    private String friends;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(friends, that.friends);
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        return (int) result;
    }

    public void update(Person person) {
        this.name=person.name;
    }
}
