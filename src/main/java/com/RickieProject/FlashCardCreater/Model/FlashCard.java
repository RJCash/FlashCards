package com.RickieProject.FlashCardCreater.Model;

import com.RickieProject.FlashCardCreater.Model.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FlashCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlashCard")
    int flashCardID;

    String question;
    String answer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    User user;

    FlashCard(){

    }

    public int getFlashCardID() {
        return flashCardID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "flashCardID=" + flashCardID +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", user=" + user +
                '}';
    }
}


