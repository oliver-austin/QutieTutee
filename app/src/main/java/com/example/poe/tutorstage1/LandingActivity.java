package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity {
    static {
        System.loadLibrary("landing-activity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Button mStudentActivity = (Button)findViewById(R.id.studentActivityButton);
        mStudentActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchStudentActivity(view);
            }
        });
        Button mTutorActivity = (Button)findViewById(R.id.tutorActivityButton);
        mTutorActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchTutorActivity(view);
            }
        });

    }
    public void switchStudentActivity(View view) {
        long ptr = (long)getIntent().getSerializableExtra("userPointer");
        Intent intent = new Intent(this, StudentProfileActivity.class);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }
    public void switchTutorActivity(View view) {
        long ptr = (long)getIntent().getSerializableExtra("userPointer");
        Intent intent = new Intent(this, TutorProfileActivity.class);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }

    public native String getName(long ptr);
}

