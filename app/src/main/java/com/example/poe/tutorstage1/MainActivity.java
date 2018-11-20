package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
    User retrieveUser = new User();
    static {
        System.loadLibrary("sign-in");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mLandingActivity = (Button)findViewById(R.id.landingActivityButton);
        mLandingActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchLandingActivity(view);
            }
        });
    }
    public void switchLandingActivity(View view) {
        APIController controller = new APIController();

        Intent intent = new Intent(this, LandingActivity.class);

        retrieveUser.setEmail("buddy@gmail.com");
        retrieveUser.setTutor(0);
        replaceNullFields(retrieveUser);
        controller.start(3, retrieveUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                retrieveUser.setName(user.getName());
                retrieveUser.setT_courses(user.getT_courses());
                retrieveUser.setLocation(user.getLocation());
                retrieveUser.setContact(user.getContact());
                retrieveUser.setBio(user.getBio());
                retrieveUser.setRate(user.getRate());
                retrieveUser.setTutor(user.getTutor());
                retrieveUser.setPassword(user.getPassword());
                retrieveUser.setS_courses(user.getS_courses());
                retrieveUser.setStatus(user.getStatus());
                retrieveUser.setEmail(user.getEmail());
                retrieveUser.setAvailable(user.getAvailable());
                retrieveUser.setDuration(user.getDuration());
                retrieveUser.setIn_session(user.getIn_session());
                retrieveUser.setStars(user.getStars());
            }
        });
        long ptr = newUser(retrieveUser);
        intent.putExtra("userPointer", ptr);
        startActivity(intent);
    }

    public void replaceNullFields(User user){
        if(user.getName() == null){
            user.setName("");
        }
        if(user.getEmail() == null) {
            user.setEmail("");
        }
        if(user.getS_courses() == null) {
            user.setS_courses("");
        }
        if(user.getT_courses() == null) {
            user.setT_courses("");
        }
        if(user.getLocation() == null) {
            user.setLocation("");
        }
        if(user.getPassword() == null) {
            user.setPassword("");
        }
        if(user.getBio() == null) {
            user.setBio("");
        }
        if(user.getContact() == null) {
            user.setContact("");
        }
        if(user.getLocation() == null) {
            user.setLocation("");
        }
    }
    public native long newUser(User user);
}
