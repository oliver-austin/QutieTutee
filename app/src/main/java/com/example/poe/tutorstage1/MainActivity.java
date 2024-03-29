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
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    User retrieveUser = new User();
    static {
        System.loadLibrary("sign-in");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button mLandingActivity = (Button)findViewById(R.id.landingActivityButton);
//        mLandingActivity.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                switchLandingActivity(view);
//            }
//        });

        Button mSignIn = (Button) findViewById(R.id.button2);
        EditText mEmail = (EditText) findViewById(R.id.editText);
        EditText mPassword = (EditText) findViewById(R.id.editText3);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signInEmailText = mEmail.getText().toString();
                String signInPasswordText = mPassword.getText().toString();
                signin(signInEmailText, signInPasswordText); }
        });

        Button mSignUp = (Button) findViewById(R.id.button);
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String signUpEmailText = mEmail.getText().toString();
                String signUpPasswordText = mPassword.getText().toString();
                signup(signUpEmailText, signUpPasswordText); }
        });
    }
//    public void switchLandingActivity(View view) {
//        APIController controller = new APIController();
//
//        Intent intent = new Intent(this, LandingActivity.class);
//
//        retrieveUser.setEmail("buddy@gmail.com");
//        retrieveUser.setTutor(0);
//        retrieveUser.setName("buddy");
//        retrieveUser.setS_courses("CMPE320");
//
//        controller.start(2, retrieveUser, new APICallbacks() {
//            @Override
//            public void onSuccess(@NonNull User user) {
//                retrieveUser.setName(user.getName());
//                retrieveUser.setT_courses(user.getT_courses());
//                retrieveUser.setLocation(user.getLocation());
//                retrieveUser.setContact(user.getContact());
//                retrieveUser.setBio(user.getBio());
//                retrieveUser.setRate(user.getRate());
//                retrieveUser.setTutor(user.getTutor());
//                retrieveUser.setPassword(user.getPassword());
//                retrieveUser.setS_courses(user.getS_courses());
//                retrieveUser.setStatus(user.getStatus());
//                retrieveUser.setEmail(user.getEmail());
//                retrieveUser.setAvailable(user.getAvailable());
//                retrieveUser.setDuration(user.getDuration());
//                retrieveUser.setIn_session(user.getIn_session());
//                retrieveUser.setStars(user.getStars());
//            }
//        });
//        long newUserPtr = newUser(retrieveUser);
//        intent.putExtra("userPointer", newUserPtr);
//        startActivity(intent);
//    }

    public void signin(String mSignInEmail, String mSignInPassword) {
        APIController controller = new APIController();
        Intent intent = new Intent(this, LandingActivity.class);
        retrieveUser.setEmail(mSignInEmail);
        retrieveUser.setPassword(mSignInPassword);
        retrieveUser.setTutor(0);
        controller.start(2, retrieveUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                if (user.email.equalsIgnoreCase(retrieveUser.getEmail()) &&
                        user.password.equals(retrieveUser.getPassword())) {
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
                    long newUserPtr = newUser(retrieveUser);
                    intent.putExtra("userPointer", newUserPtr);
                    startActivity(intent);
                } else {
                    retrieveUser.setTutor(1);
                    controller.start(2, retrieveUser, new APICallbacks() {
                        @Override
                        public void onSuccess(@NonNull User user) {
                            if (user.email.equalsIgnoreCase(retrieveUser.getEmail()) &&
                                    user.password.equals(retrieveUser.getPassword())) {
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
                                long newUserPtr = newUser(retrieveUser);
                                intent.putExtra("userPointer", newUserPtr);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "User does not exist",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }

        });
    }
    public void signup(String mSignUpEmail, String mSignUpPassword) {
        APIController controller = new APIController();
        Intent intent = new Intent(this, LandingActivity.class);
        retrieveUser.setEmail(mSignUpEmail.toLowerCase());
        retrieveUser.setPassword(mSignUpPassword);
        if(retrieveUser.getEmail().isEmpty() || retrieveUser.getPassword().isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter your email address and desired password",
                    Toast.LENGTH_LONG).show();
        } else {
            controller.start(2, retrieveUser, new APICallbacks() {

                @Override
                public void onSuccess(@NonNull User user) {
                    if(user.email == "No user found"){
                        retrieveUser.setTutor(1);
                        controller.start(2, retrieveUser, new APICallbacks() {
                            @Override
                            public void onSuccess(@NonNull User user) {
                                if (user.email == "No user found") {
                                    controller.start(3, retrieveUser, new APICallbacks() {
                                        @Override
                                        public void onSuccess(@NonNull User user) {
                                            long newUserPtr = newUser(retrieveUser);
                                            intent.putExtra("userPointer", newUserPtr);
                                            startActivity(intent);
                                        }
                                    });
                                } else {
                                    Toast.makeText(MainActivity.this, "User already exists",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(MainActivity.this, "User already exists",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
    public native long newUser(User user); //returns C++ pointer to user
}