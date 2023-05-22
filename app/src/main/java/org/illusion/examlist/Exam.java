package org.illusion.examlist;

import android.annotation.SuppressLint;

public class Exam {
    private String name;
    private String subject;
    private String examiner;
    private int semester;
    private int mark;
    private String location;

    public Exam(String name, String subject, String examiner, int semester, int mark, String location) {
        this.name = name;
        this.subject = subject;
        this.examiner = examiner;
        this.semester = semester;
        this.mark = mark;
        this.location = location;
    }

    public String getName() {
        return name;
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
