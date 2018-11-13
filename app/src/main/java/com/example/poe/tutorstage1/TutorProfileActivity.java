package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TutorProfileActivity extends AppCompatActivity {
    static {
        System.loadLibrary("tutor-profile");
    }
    private EditText mName;
    private EditText mClassTeach;
    private EditText mContact;
    private EditText mRate;
    private EditText mBio;
    private Button mSave;
    private Button mEdit;
    private Button mSwitchToStudentActivity;
    private Button mSetStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);

        mName = findViewById(R.id.NameTextBox);
        mClassTeach = findViewById(R.id.CoursesTextBox);
        mContact = findViewById(R.id.ContactInfoTextBox);
        mRate = findViewById(R.id.RateTextBox);
        mBio = findViewById(R.id.BioTextBox);
        mSwitchToStudentActivity = findViewById(R.id.SwitchToStudentButton);


        mName.setFocusableInTouchMode(false);
        mClassTeach.setFocusableInTouchMode(false);
        mContact.setFocusableInTouchMode(false);
        mRate.setFocusableInTouchMode(false);
        mBio.setFocusableInTouchMode(false);

        mSave = findViewById(R.id.saveProfile);
        mSave.setVisibility(View.INVISIBLE);
        mSave.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                String userName =  mName.getText().toString();
                String userClassTeach =  mClassTeach.getText().toString();
                String userContact =  mContact.getText().toString();
                String userRate =  mRate.getText().toString();
                String userBio =  mBio.getText().toString();

                String newUserInfo = saveProfile(userName, userClassTeach, userContact, userRate, userBio);
            /*
                Toast.makeText(TutorProfileActivity.this, newUserName,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(TutorProfileActivity.this, newuserClassTeach,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(TutorProfileActivity.this, newuserContact,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(TutorProfileActivity.this, newuserRate,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(TutorProfileActivity.this, newuserBio,
                        Toast.LENGTH_LONG).show();
              */
                toggleSaveProfile();


            }
        });

        Button mSwitchToStudentActivity = (Button)findViewById(R.id.SwitchToStudentButton);
        mSwitchToStudentActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchStudentProfileActivity(view);
            }
        });
        mEdit = findViewById(R.id.enterEditMode);
        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleEditProfile();
            }

        });
        mSetStatus = findViewById(R.id.SetStatusBox);
        mSetStatus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switchTutorStatusActivity(view);
            }

        });

    }
    public void toggleEditProfile(){
        mName.setFocusableInTouchMode(true);
        mClassTeach.setFocusableInTouchMode(true);
        mContact.setFocusableInTouchMode(true);
        mRate.setFocusableInTouchMode(true);
        mBio.setFocusableInTouchMode(true);

        mSave.setVisibility(View.VISIBLE);
        mEdit.setVisibility(View.INVISIBLE);
        mSwitchToStudentActivity.setVisibility(View.INVISIBLE);
    }

    public void toggleSaveProfile(){
        mName.setFocusableInTouchMode(false);
        mClassTeach.setFocusableInTouchMode(false);
        mContact.setFocusableInTouchMode(false);
        mRate.setFocusableInTouchMode(false);
        mBio.setFocusableInTouchMode(false);

        mSave.setVisibility(View.INVISIBLE);
        mEdit.setVisibility(View.VISIBLE);
        mSwitchToStudentActivity.setVisibility(View.VISIBLE);

        mName.clearFocus();
        mClassTeach.clearFocus();
        mContact.clearFocus();
        mRate.clearFocus();
        mBio.clearFocus();



    }
    public void switchTutorStatusActivity(View view) {
        Intent intent = new Intent(this, TutorStatusActivity.class);
        startActivity(intent);
    }
    public void switchStudentProfileActivity(View view) {
        Intent intent = new Intent(this, StudentProfileActivity.class);
        startActivity(intent);
    }
    public native String saveProfile(String Variable,String userClassTeach, String userContact, String userRate, String userBio);

}
