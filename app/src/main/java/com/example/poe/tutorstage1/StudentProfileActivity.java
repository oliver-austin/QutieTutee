package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

public class StudentProfileActivity extends AppCompatActivity {
    static {
        System.loadLibrary("student-profile");
    }
    List<User> allUsers = new ArrayList<>();
    List<User> releventUsers = new ArrayList<>();
    private EditText mName;
    private EditText mCourse;
    private Button mSave;
    private Button mEdit;
    private Button mSwitchToTutorActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        long ptr = (long)getIntent().getSerializableExtra("userPointer");
        mName = findViewById(R.id.userName);
        mCourse = findViewById(R.id.classList);

        // set initial entries of profile
        String name = getUserName(ptr);
        String course = getStudentCourse(ptr);
        if(!name.equals("")){
            mName.setText(name);
        }
        if(!course.equals("")){
            mCourse.setText(course);
        }
        mName.setFocusableInTouchMode(false);
        mCourse.setFocusableInTouchMode(false);

        mSave = findViewById(R.id.saveProfile);
        mSave.setVisibility(View.INVISIBLE);
        mSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //create new user
                User user = new User();
                //set user fields
                String userName =  mName.getText().toString();
                String studentCourse = mCourse.getText().toString();
                user.setName(userName);
                user.setS_courses(studentCourse);
                user.setEmail(getEmail(ptr));
                user.setPassword(getPassword(ptr));
                user.setT_courses(getTutorCourse(ptr));
                user.setTutor(getTutor(ptr));
                user.setBio(getBio(ptr));
                user.setRate(getRate(ptr));
                user.setLocation(getLocation(ptr));
                user.setStatus(getStatus(ptr));
                user.setContact(getContact(ptr));
                user.setAvailable(getAvailable(ptr));
                user.setDuration(getDuration(ptr));
                user.setIn_session(getInSession(ptr));
                user.setStars(getStars(ptr));

                APIController controller = new APIController();
                        controller.start(4, user, new APICallbacks() {
                            @Override
                            public void onSuccess(@NonNull User user) {
                            }
                        });
                saveProfile(ptr, userName, studentCourse);
                toggleSaveProfile();
            }
        });

        Button mTutorListActivity = (Button) findViewById(R.id.tutorListActivityButton);
        mTutorListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(mCourse.getText().toString().equals("")){
                    Toast.makeText(StudentProfileActivity.this, "Please enter a course",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    switchTutorListActivity(view, ptr);
                }
            }
        });
        mSwitchToTutorActivity = findViewById(R.id.SwitchToTutorButton);
        mSwitchToTutorActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchTutorProfileActivity(view, ptr);
            }
        });
        mEdit = findViewById(R.id.enterEditMode);
        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleEditProfile();
            }

        });
    }
    public void switchTutorListActivity(View view, long ptr) {
        Intent intent = new Intent(this, TutorListActivity.class);
        APIController controller = new APIController();
        controller.startGetTutors(allUsers, new APICallbacksGetTutors() {
            @Override
            public void onSuccess(@NonNull List<User> users) {
                String tString;
                System.out.println("+++SUCCESS");
                allUsers.addAll(users);

                intent.putExtra("userPointer", ptr);
                //Bundle bundle = new Bundle();
                //bundle.putParcelableArrayList("tutorList", allUsers);
                intent.putExtra("tutorList", (Serializable) allUsers);
                startActivity(intent);
            }
        });

    }
    public void toggleEditProfile(){
        mName.setFocusableInTouchMode(true);
        mCourse.setFocusableInTouchMode(true);
        mSave.setVisibility(View.VISIBLE);
        mEdit.setVisibility(View.INVISIBLE);
        mSwitchToTutorActivity.setVisibility(View.INVISIBLE);
    }
    public void toggleSaveProfile(){
        mName.setFocusableInTouchMode(false);
        mCourse.setFocusableInTouchMode(false);
        mSave.setVisibility(View.INVISIBLE);
        mEdit.setVisibility(View.VISIBLE);
        mSwitchToTutorActivity.setVisibility(View.VISIBLE);
        mName.clearFocus();
        mCourse.clearFocus();
    }
    public void switchTutorProfileActivity(View view, long ptr) {
        Intent intent = new Intent(this, TutorProfileActivity.class);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }
    public native void saveProfile(long ptr, String name, String course);
    public native String getUserName(long ptr);
    public native String getStudentCourse(long ptr);
    public native String getEmail(long ptr);
    public native String getPassword(long ptr);
    public native String getTutorCourse(long ptr);
    public native String getBio(long ptr);
    public native String getLocation(long ptr);
    public native String getContact(long ptr);
    public native int getTutor(long ptr);
    public native double getRate(long ptr);
    public native int getStatus(long ptr);
    public native int getAvailable(long ptr);
    public native int getDuration(long ptr);
    public native int getInSession(long ptr);
    public native double getStars(long ptr);
}

