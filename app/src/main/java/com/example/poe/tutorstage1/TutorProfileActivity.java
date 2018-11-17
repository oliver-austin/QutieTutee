package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TutorProfileActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }
    private EditText mName;
    private EditText mCourse;
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
        long ptr = (long)getIntent().getSerializableExtra("userPointer");

        mName = findViewById(R.id.NameTextBox);
        mCourse = findViewById(R.id.CoursesTextBox);
        mContact = findViewById(R.id.ContactInfoTextBox);
        mRate = findViewById(R.id.RateTextBox);
        mBio = findViewById(R.id.BioTextBox);
        mSwitchToStudentActivity = findViewById(R.id.SwitchToStudentButton);

        // set initial entries of profile
        String name = getUserName(ptr);
        String course = getTutorCourse(ptr);
        String contact = getContact(ptr);
        String bio = getBio(ptr);
        double rate = getRate(ptr);

        if(!name.equals("")){
            mName.setText(name);
        }
        if(!course.equals("")){
            mCourse.setText(course);
        }
        if(!contact.equals("")){
            mContact.setText(contact);
        }
        if(!bio.equals("")){
            mBio.setText(bio);
        }
        if(rate != 0){
            String stringRate = Double.toString(rate);
            mRate.setText(stringRate);
        }


        mName.setFocusableInTouchMode(false);
        mCourse.setFocusableInTouchMode(false);
        mContact.setFocusableInTouchMode(false);
        mRate.setFocusableInTouchMode(false);
        mBio.setFocusableInTouchMode(false);

        mSave = findViewById(R.id.saveProfile);
        mSave.setVisibility(View.INVISIBLE);
        mSave.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
//create new user
                User user = new User();
                //set user fields
                String userName =  mName.getText().toString();
                String tutorCourse = mCourse.getText().toString();
                String bio = mBio.getText().toString();
                String contact = mContact.getText().toString();
                String rateString = mRate.getText().toString();
                Double rate;
                if(rateString.isEmpty()){
                    rate = 0.0;
                }
                else{
                    rate = Double.parseDouble(rateString);
                }

                user.setName(userName);
                user.setS_courses(getStudentCourse(ptr));
                user.setContact(contact);
                user.setEmail(getEmail(ptr));
                user.setPwrd(getPassword(ptr));
                user.setT_courses(tutorCourse);
                user.setTutor(getTutor(ptr));
                user.setBio(bio);
                user.setRate(rate);

                // call api to update user
                //APIController controller = new APIController();
                //        controller.start(4, user);
                saveProfile(ptr, userName, tutorCourse, bio, contact, rate);
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
        mCourse.setFocusableInTouchMode(true);
        mContact.setFocusableInTouchMode(true);
        mRate.setFocusableInTouchMode(true);
        mBio.setFocusableInTouchMode(true);

        mSave.setVisibility(View.VISIBLE);
        mEdit.setVisibility(View.INVISIBLE);
        mSwitchToStudentActivity.setVisibility(View.INVISIBLE);
    }

    public void toggleSaveProfile(){
        mName.setFocusableInTouchMode(false);
        mCourse.setFocusableInTouchMode(false);
        mContact.setFocusableInTouchMode(false);
        mRate.setFocusableInTouchMode(false);
        mBio.setFocusableInTouchMode(false);

        mSave.setVisibility(View.INVISIBLE);
        mEdit.setVisibility(View.VISIBLE);
        mSwitchToStudentActivity.setVisibility(View.VISIBLE);

        mName.clearFocus();
        mCourse.clearFocus();
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
    public native void saveProfile(long ptr, String name, String course, String bio, String contact, double rate);
    public native String getUserName(long ptr);
    public native String getStudentCourse(long ptr);
    public native String getEmail(long ptr);
    public native String getPassword(long ptr);
    public native String getTutorCourse(long ptr);
    public native String getBio(long ptr);
    public native String getContact(long ptr);
    public native int getTutor(long ptr);
    public native double getRate(long ptr);
}
