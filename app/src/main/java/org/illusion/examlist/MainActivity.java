package org.illusion.examlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ExamCollection examCollection = ExamCollection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.examList);

        ExamAdapter adapter = new ExamAdapter(this, examCollection.toList());
        recyclerView.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateExamFirstActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_about) {
            showAboutActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutActivity() {
        // Replace AboutActivity.class with your actual About activity
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void showCreateExamFirstActivity() {
        Intent intent = new Intent(this, CreateExamFirstActivity.class);
        startActivity(intent);
    }

    private void setInitialData(){
        examCollection.addExam(new Exam("Exam 1", "Subject 1", "Examiner 1", (byte) 1, 80, "Location 1"));
        examCollection.addExam(new Exam("Exam 2", "Subject 2", "Examiner 2", (byte) 2, 75, "Location 2"));
        examCollection.addExam(new Exam("Exam 3", "Subject 3", "Examiner 3", (byte) 1, 90, "Location 3"));
        examCollection.addExam(new Exam("Exam 4", "Subject 4", "Examiner 4", (byte) 2, 85, "Location 4"));
        examCollection.addExam(new Exam("Exam 5", "Subject 5", "Examiner 5", (byte) 1, 95, "Location 5"));
        examCollection.addExam(new Exam("Exam 6", "Subject 6", "Examiner 6", (byte) 2, 70, "Location 6"));
        examCollection.addExam(new Exam("Exam 7", "Subject 7", "Examiner 7", (byte) 1, 88, "Location 7"));
        examCollection.addExam(new Exam("Exam 8", "Subject 8", "Examiner 8", (byte) 2, 92, "Location 8"));
        examCollection.addExam(new Exam("Exam 9", "Subject 9", "Examiner 9", (byte) 1, 79, "Location 9"));
        examCollection.addExam(new Exam("Exam 10", "Subject 10", "Examiner 10", (byte) 2, 87, "Location 10"));

        examCollection.addExam(new Exam("Exam 1", "Subject 1", "Examiner 1", (byte) 1, 80, "Location 1"));
        examCollection.addExam(new Exam("Exam 2", "Subject 2", "Examiner 2", (byte) 2, 75, "Location 2"));
        examCollection.addExam(new Exam("Exam 3", "Subject 3", "Examiner 3", (byte) 1, 90, "Location 3"));
        examCollection.addExam(new Exam("Exam 4", "Subject 4", "Examiner 4", (byte) 2, 85, "Location 4"));
        examCollection.addExam(new Exam("Exam 5", "Subject 5", "Examiner 5", (byte) 1, 95, "Location 5"));
        examCollection.addExam(new Exam("Exam 6", "Subject 6", "Examiner 6", (byte) 2, 70, "Location 6"));
        examCollection.addExam(new Exam("Exam 7", "Subject 7", "Examiner 7", (byte) 1, 88, "Location 7"));
        examCollection.addExam(new Exam("Exam 8", "Subject 8", "Examiner 8", (byte) 2, 92, "Location 8"));
        examCollection.addExam(new Exam("Exam 9", "Subject 9", "Examiner 9", (byte) 1, 79, "Location 9"));
        examCollection.addExam(new Exam("Exam 10", "Subject 10", "Examiner 10", (byte) 2, 87, "Location 10"));
    }
}