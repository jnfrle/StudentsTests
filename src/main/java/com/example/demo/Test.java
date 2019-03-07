package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String subject;
    private String date;
    private int score;
    private String student;

    @OneToMany(mappedBy = "student")
    private Set<StudentsAndTests> students;

    public Test() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<StudentsAndTests> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentsAndTests> students) {
        this.students = students;
    }
}
