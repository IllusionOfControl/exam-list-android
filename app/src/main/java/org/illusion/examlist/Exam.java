package org.illusion.examlist;

public class Exam {
    private String title;
    private String subject;
    private String examiner;
    private int semester;
    private int mark;
    private String location;

    public Exam(String title, String subject, String examiner, int semester, int mark, String location) {
        this.title = title;
        this.subject = subject;
        this.examiner = examiner;
        this.semester = semester;
        this.mark = mark;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getExaminer() {
        return examiner;
    }

    public int getSemester() {
        return semester;
    }

    public int getMark() {
        return mark;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return String.format("%s, %s, %d", location, examiner, mark);
    }
}
