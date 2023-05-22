package org.illusion.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateExamSecondActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_THIRD_ACTIVITY = 2;
    private TextView nameTextView;
    private TextView versionTextView;
    private TextView licenseTextView;
    private Button nextButton;

    private String name;
    private String version;
    private String license;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_second);

        nameTextView = findViewById(R.id.nameTextView);
        versionTextView = findViewById(R.id.versionTextView);
        licenseTextView = findViewById(R.id.licenseTextView);
        nextButton = findViewById(R.id.nextButton);

        name = getIntent().getStringExtra("name");
        version = getIntent().getStringExtra("version");
        license = getIntent().getStringExtra("license");

        nameTextView.setText(name);
        versionTextView.setText(version);
        licenseTextView.setText(license);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateExamSecondActivity.this, CreateExamThirdActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("version", version);
                intent.putExtra("license", license);
                startActivityForResult(intent, REQUEST_CODE_THIRD_ACTIVITY);
            }
        });
    }
}