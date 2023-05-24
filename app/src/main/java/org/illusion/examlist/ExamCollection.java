package org.illusion.examlist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ExamCollection {
    private static ExamCollection instance;
    private List<Exam> exams;

    private ExamCollection() {
        exams = new ArrayList<>();
    }

    public static synchronized ExamCollection getInstance() {
        if (instance == null) {
            instance = new ExamCollection();
        }
        return instance;
    }

    public void loadExams(Context context) {
        exams = FileUtil.loadItemListFromJson(context);
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void removeExam(Exam exam) {
        exams.remove(exam);
    }

    public List<Exam> toList() {
        return exams;
    }
}