package com.RickieProject.FlashCardCreater.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    int userID;
    String username;
    String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    private Set<Role> roles = new HashSet<>();


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<FlashCard> cards;

    String name;

    User(String name){
        this.name = name;

    }
    User(){

    }
    User(Set<Role> roles, Set<FlashCard> cards){
        this.roles = roles;
        this.cards = cards;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", cards=" + cards +
                ", name='" + name + '\'' +
                '}';
    }
}
