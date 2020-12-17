package com.RickieProject.FlashCardCreater.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flash_card")
public class FlashCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflashcard")
    int flashCardID;
    @Column(name ="question")
    String question;
    @Column(name ="answer")
    String answer;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

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


