package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentProfileActivity extends AppCompatActivity {
    static {
        System.loadLibrary("student-profile");
    }
    private EditText mName;
    private EditText mClass;
    private Button mSave;
    private Button mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        mName = findViewById(R.id.userName);
        mClass = findViewById(R.id.classList);

        mName.setFocusableInTouchMode(false);
        mClass.setFocusableInTouchMode(false);

        mSave = findViewById(R.id.saveProfile);
        mSave.setVisibility(View.INVISIBLE);
        mSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userName =  mName.getText().toString();
                String newUserName = saveProfile(userName);
                Toast.makeText(StudentProfileActivity.this, newUserName,
                        Toast.LENGTH_LONG).show();
                toggleSaveProfile();
            }
        });

        Button mTutorListActivity = (Button) findViewById(R.id.tutorListActivityButton);
        mTutorListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switchTutorListActivity(view);
            }
        });
        mEdit = findViewById(R.id.enterEditMode);
        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleEditProfile();
            }

        });
    }
    public void switchTutorListActivity(View view) {
        Intent intent = new Intent(this, TutorListActivity.class);
        startActivity(intent);
    }
    public void toggleEditProfile(){
            mName.setFocusableInTouchMode(true);
            mClass.setFocusableInTouchMode(true);
            mSave.setVisibility(View.VISIBLE);
            mEdit.setVisibility(View.INVISIBLE);
    }
    public void toggleSaveProfile(){
        mName.setFocusableInTouchMode(false);
        mClass.setFocusableInTouchMode(false);
        mSave.setVisibility(View.INVISIBLE);
        mEdit.setVisibility(View.VISIBLE);
        mName.clearFocus();
        mClass.clearFocus();

    }
    public native String saveProfile(String userName);
}
