package com.ltp.gradesubmission;

import java.util.UUID;

public class Grade {
    private String id;
    private String name;
    private String subject;
    private String score;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
    
    public Grade(String id, String name, String subject, String score) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public GradeForm toGradeForm(){
        return new GradeForm(this.id, this.name, this.subject, this.score, false);
    }
}
