package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TutorProfileActivity extends AppCompatActivity {
    static {
        System.loadLibrary("tutor-profile");
    }
    private EditText mName;
    private EditText mCourse;
    private EditText mContact;
    private EditText mRate;
    private EditText mBio;
    private EditText mLocation;
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
        mLocation = findViewById(R.id.LocationTextBox);
        mSwitchToStudentActivity = findViewById(R.id.SwitchToStudentButton);

        // set initial entries of profile
        String name = getUserName(ptr);
        String course = getTutorCourse(ptr);
        String contact = getContact(ptr);
        String bio = getBio(ptr);
        String location = getLocation(ptr);
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
        if(!location.equals("")){
            mLocation.setText(location);
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
        mLocation.setFocusableInTouchMode(false);

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
                String location = mLocation.getText().toString();
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
                user.setLocation(location);
                user.setStatus(getStatus(ptr));

                // call api to update user
                //APIController controller = new APIController();
                //        controller.start(4, user);
                saveProfile(ptr, userName, tutorCourse, bio, contact, rate, location);
                toggleSaveProfile();

            }
        });

        Button mSwitchToStudentActivity = (Button)findViewById(R.id.SwitchToStudentButton);
        mSwitchToStudentActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchStudentProfileActivity(view, ptr);
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
                switchTutorStatusActivity(view, ptr);
            }

        });

    }
    public void toggleEditProfile(){
        mName.setFocusableInTouchMode(true);
        mCourse.setFocusableInTouchMode(true);
        mContact.setFocusableInTouchMode(true);
        mRate.setFocusableInTouchMode(true);
        mBio.setFocusableInTouchMode(true);
        mLocation.setFocusableInTouchMode(true);

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
        mLocation.setFocusableInTouchMode(false);

        mSave.setVisibility(View.INVISIBLE);
        mEdit.setVisibility(View.VISIBLE);
        mSwitchToStudentActivity.setVisibility(View.VISIBLE);

        mName.clearFocus();
        mCourse.clearFocus();
        mContact.clearFocus();
        mRate.clearFocus();
        mBio.clearFocus();
        mLocation.clearFocus();

    }
    public void switchTutorStatusActivity(View view, long ptr) {
        Intent intent = new Intent(this, TutorStatusActivity.class);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }
    public void switchStudentProfileActivity(View view, long ptr) {
        Intent intent = new Intent(this, StudentProfileActivity.class);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }
    public native void saveProfile(long ptr, String name, String course, String bio, String contact, double rate, String location);
    public native String getUserName(long ptr);
    public native String getStudentCourse(long ptr);
    public native String getEmail(long ptr);
    public native String getPassword(long ptr);
    public native String getTutorCourse(long ptr);
    public native String getBio(long ptr);
    public native String getContact(long ptr);
    public native String getLocation(long ptr);
    public native int getTutor(long ptr);
    public native double getRate(long ptr);
    public native int getStatus(long ptr);
}
