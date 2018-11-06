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
        System.loadLibrary("native-lib");
    }
    private EditText mName;
    private EditText mClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        mName = findViewById(R.id.userName);
        mClass = findViewById(R.id.classList);
        mName.setFocusable(true);
        mClass.setFocusable(true);
        Button mTutorListActivity = (Button) findViewById(R.id.tutorListActivityButton);
        mTutorListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switchTutorListActivity(view);
            }
        });
        Button mStudentProfileEdit = (Button) findViewById(R.id.enterEditMode);
        mStudentProfileEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleEditProfile();
            }

        });
        Button mSave = (Button)findViewById(R.id.saveProfile);
        mSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userName =  mName.getText().toString();
                String newUserName = saveProfile(userName);
                Toast.makeText(StudentProfileActivity.this, newUserName,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    public void switchTutorListActivity(View view) {
        Intent intent = new Intent(this, TutorListActivity.class);
        startActivity(intent);
    }
    public void toggleEditProfile(){
        if(mName.isFocusable()){
            mName.setFocusable(false);
            mClass.setFocusable(false);
        }
        else{
            mName.setFocusable(true);
            mClass.setFocusable(true);
        }
    }
    public native String saveProfile(String userName);
}
