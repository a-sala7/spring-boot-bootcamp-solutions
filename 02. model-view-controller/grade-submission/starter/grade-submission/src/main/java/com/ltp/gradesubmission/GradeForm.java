package com.ltp.gradesubmission;

public class GradeForm {
    private String name;
    private String subject;
    private String score;
    private boolean submittingAgain;

    public GradeForm() {}

    public GradeForm(String name, String subject, String score, boolean submittingAgain) {
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

    public Grade toGrade() {
        return new Grade(this.name, this.subject, this.score);
    }
}
