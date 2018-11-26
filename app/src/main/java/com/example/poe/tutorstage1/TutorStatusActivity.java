package com.example.poe.tutorstage1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorStatusActivity extends AppCompatActivity {
    User user = new User();
    static {
        System.loadLibrary("native-lib");
    }
    private Button mActive;
    private Button mInactive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_status);
        long ptr = (long)getIntent().getSerializableExtra("userPointer");

        mActive = findViewById(R.id.buttonActive);
        mInactive = findViewById(R.id.buttonInactive);
        user.setStatus(getStatus(ptr));
        if (user.getStatus()==0){
            mActive.setVisibility(View.INVISIBLE);
            mInactive.setVisibility(View.VISIBLE);
        }else{
            mActive.setVisibility(View.VISIBLE);
            mInactive.setVisibility(View.INVISIBLE);
        }

        mActive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleActive(ptr);
            }

        });


        mInactive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleInactive(ptr);
            }

        });


    }
    public void toggleActive(long ptr){
        mActive.setVisibility(View.INVISIBLE);
        mInactive.setVisibility(View.VISIBLE);
        user.setName(getUserName(ptr));
        user.setS_courses(getStudentCourse(ptr));
        user.setContact(getContact(ptr));
        user.setEmail(getEmail(ptr));
        user.setPassword(getPassword(ptr));
        user.setT_courses(getTutorCourse(ptr));
        user.setTutor(getTutor(ptr));
        user.setBio(getBio(ptr));
        user.setRate(getRate(ptr));
        user.setLocation(getLocation(ptr));
        user.setStatus(0);
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
        setInactive(ptr);
    }
    public void toggleInactive(long ptr){
        mActive.setVisibility(View.VISIBLE);
        mInactive.setVisibility(View.INVISIBLE);

        user.setName(getUserName(ptr));
        user.setS_courses(getStudentCourse(ptr));
        user.setContact(getContact(ptr));
        user.setEmail(getEmail(ptr));
        user.setPassword(getPassword(ptr));
        user.setT_courses(getTutorCourse(ptr));
        user.setTutor(getTutor(ptr));
        user.setBio(getBio(ptr));
        user.setRate(getRate(ptr));
        user.setLocation(getLocation(ptr));
        user.setStatus(1);
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
        setActive(ptr);
    }

    public native void setActive(long ptr);
    public native void setInactive(long ptr);
    public native int getStatus(long ptr);
    public native String getEmail(long ptr);
    public native int getTutor(long ptr);



    public native String getUserName(long ptr);
    public native String getStudentCourse(long ptr);
    public native String getPassword(long ptr);
    public native String getTutorCourse(long ptr);
    public native String getBio(long ptr);
    public native String getContact(long ptr);
    public native String getLocation(long ptr);
    public native double getRate(long ptr);
    public native int getAvailable(long ptr);
    public native int getDuration(long ptr);
    public native int getInSession(long ptr);
    public native double getStars(long ptr);

}
