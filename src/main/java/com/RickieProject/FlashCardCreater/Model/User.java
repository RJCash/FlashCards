package com.RickieProject.FlashCardCreater.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    //note: MySQL auto underscores and lowercases IDs ex. idUser becomes id_user. Better to set all IDs lowercase
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser")
    int userID;
    @Column(name="name")
    String name;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;

    //note: fetch type EAGER is used to avoid LazyInitializationException error (may change).
    //Good for a small projects like this, but not so for large ones based on n+1 overhead reads.
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName="idUser"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="idRole")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",
            cascade = CascadeType.ALL)
    Set<FlashCard> cards = new HashSet<>();


    public User(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUserID() {
        return userID;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<FlashCard> getCards() {
        return cards;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCards(Set<FlashCard> cards) {
        this.cards = cards;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +

                ", cards=" + cards +
                '}';
    }
}
