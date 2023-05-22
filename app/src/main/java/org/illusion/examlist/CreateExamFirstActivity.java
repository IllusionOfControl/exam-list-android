package org.illusion.examlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateExamFirstActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SECOND_ACTIVITY = 1;
    private EditText nameEditText;
    private EditText versionEditText;
    private EditText licenseEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_first);

        nameEditText = findViewById(R.id.nameEditText);
        versionEditText = findViewById(R.id.versionEditText);
        licenseEditText = findViewById(R.id.licenseEditText);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String version = versionEditText.getText().toString();
                String license = licenseEditText.getText().toString();

                Intent intent = new Intent(CreateExamFirstActivity.this, CreateExamSecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("version", version);
                intent.putExtra("license", license);
                startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY && resultCode == RESULT_OK) {
            // Handle any result data if needed
        }
    }
}


