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
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ExamCollection examCollection = ExamCollection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.examList);

        IOnExamClickListener examClickListener = new IOnExamClickListener() {
            @Override
            public void onExamClick(Exam exam) {
                Intent intent = new Intent(MainActivity.this, ExamDetailsActivity.class);
                intent.putExtra("examiner", exam.getExaminer());
                intent.putExtra("semester", Integer.toString(exam.getSemester()));
                intent.putExtra("location", exam.getLocation());
                intent.putExtra("title", exam.getTitle());
                intent.putExtra("subject", exam.getSubject());
                intent.putExtra("mark", Integer.toString(exam.getMark()));
                startActivity(intent);
            }
        };

        ExamAdapter adapter = new ExamAdapter(this, examCollection.toList(), examClickListener);
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
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
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
        if (itemId == R.id.action_export) {
            saveExamData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutActivity() {
        // Replace AboutActivity.class with your actual About activity
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void saveExamData() {
        FileUtil.saveItemListToJson(examCollection.toList(), this);
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    private void showCreateExamFirstActivity() {
        Intent intent = new Intent(this, CreateExamFirstActivity.class);
        startActivity(intent);
    }
}