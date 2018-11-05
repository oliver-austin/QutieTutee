package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Button mTutorListActivity = (Button)findViewById(R.id.tutorListActivityButton);
        mTutorListActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchTutorListActivity(view);
            }
        });

        Button mStudentProfileEditActivity = (Button)findViewById(R.id.enterEditMode);
        mStudentProfileEditActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchStudentProfileEditActivity(view);
            }
        });

    }
    public void switchTutorListActivity(View view) {
        Intent intent = new Intent(this, TutorListActivity.class);
        startActivity(intent);
    }

    public void switchStudentProfileEditActivity(View view) {
        Intent intent = new Intent(this, StudentProfileEditActivity.class);
        startActivity(intent);
    }


}
