package org.illusion.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateExamThirdActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView versionTextView;
    private TextView licenseTextView;
    private Button confirmButton;

    private String name;
    private String version;
    private String license;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_third);

        nameTextView = findViewById(R.id.nameTextView);
        versionTextView = findViewById(R.id.versionTextView);
        licenseTextView = findViewById(R.id.licenseTextView);
        confirmButton = findViewById(R.id.confirmButton);

        name = getIntent().getStringExtra("name");
        version = getIntent().getStringExtra("version");
        license = getIntent().getStringExtra("license");

        nameTextView.setText(name);
        versionTextView.setText(version);
        licenseTextView.setText(license);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the values to an object and collection
                // For example:
                Exam exam = new Exam(",",",",",",2, 2, "");
                ExamCollection.getInstance().addExam(exam);

                // Finish the activity and return to the previous activity
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}