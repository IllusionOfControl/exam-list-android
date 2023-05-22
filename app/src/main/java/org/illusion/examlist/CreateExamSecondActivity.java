package org.illusion.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateExamSecondActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_THIRD_ACTIVITY = 2;
    private TextView examinerEditText;
    private TextView semesterEditText;
    private TextView titleTextView;
    private TextView subjectTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_second);

        examinerEditText = findViewById(R.id.examinerEditText);
        semesterEditText = findViewById(R.id.semesterEditText);
        titleTextView = findViewById(R.id.titleTextView);
        subjectTextView = findViewById(R.id.subjectTextView);

        String title = getIntent().getStringExtra("title");
        String subject = getIntent().getStringExtra("subject");

        titleTextView.setText("Title: " + title);
        subjectTextView.setText("Subject: " + subject);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String examiner = examinerEditText.getText().toString();
                String semester = semesterEditText.getText().toString();

                String title = getIntent().getStringExtra("title");
                String subject = getIntent().getStringExtra("subject");

                Intent intent = new Intent(CreateExamSecondActivity.this, CreateExamThirdActivity.class);
                intent.putExtra("examiner", examiner);
                intent.putExtra("semester", semester);
                intent.putExtra("title", title);
                intent.putExtra("subject", subject);


                startActivityForResult(intent, REQUEST_CODE_THIRD_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_THIRD_ACTIVITY && resultCode == RESULT_OK) {
            examinerEditText.setText(data.getStringExtra("examiner"));
            semesterEditText.setText(data.getStringExtra("semester"));
        }
    }
}