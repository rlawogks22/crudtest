package com.example.crudtest.Entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String subject;
    private String content;
    private String name;
    private int vicwcnt;
    private String regdate;

    public Board() {
    }

    public Board(int uid, String subject, String content, String name, int vicwcnt, String regdate) {
        this.uid = uid;
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.vicwcnt = vicwcnt;
        this.regdate = regdate;
    }
}