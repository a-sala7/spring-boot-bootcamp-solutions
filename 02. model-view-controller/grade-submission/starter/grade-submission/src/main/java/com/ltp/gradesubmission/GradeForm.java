package com.ltp.gradesubmission;

import java.util.UUID;

public class GradeForm {
    private String id;
    private String name;
    private String subject;
    private String score;
    private boolean submittingAgain;

    public GradeForm() {}

    public GradeForm(String id, String name, String subject, String score, boolean submittingAgain) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.submittingAgain = submittingAgain;
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
    public boolean isSubmittingAgain() {
        return submittingAgain;
    }
    public void setSubmittingAgain(boolean submittingAgain) {
        this.submittingAgain = submittingAgain;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public Grade toGrade() {
        if(this.id == null || this.id.trim().equals("")){
            return new Grade(UUID.randomUUID().toString(), this.name, this.subject, this.score);
        }
        return new Grade(this.id, this.name, this.subject, this.score);
    }
}
