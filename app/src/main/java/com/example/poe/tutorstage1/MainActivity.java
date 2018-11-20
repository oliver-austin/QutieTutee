package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements Serializable {
    User retrieveUser = new User();
    User testStudentUser = new User();
    User testTutorUser = new User();
    List<User> listOfDbUsers;
    List<User> newUsers;

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

        Button mSignIn = (Button) findViewById(R.id.button2);
        EditText mSignInEmail = (EditText) findViewById(R.id.editText4);
        EditText mSignInPassword = (EditText) findViewById(R.id.editText5);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signInEmailText = mSignInEmail.getText().toString();
                String signInPasswordText = mSignInPassword.getText().toString();
                signin(signInEmailText, signInPasswordText); }
        });

        Button mSignUp = (Button) findViewById(R.id.button);
        EditText mSignUpEmail = (EditText) findViewById(R.id.editText);
        EditText mSignUpPassword = (EditText) findViewById(R.id.editText3);
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String signUpEmailText = mSignUpEmail.getText().toString();
                String signUpPasswordText = mSignUpPassword.getText().toString();
                signup(signUpEmailText, signUpPasswordText); }
        });

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }
    public void switchLandingActivity(View view) {
        APIController controller = new APIController();

        Intent intent = new Intent(this, LandingActivity.class);

        retrieveUser.setEmail("buddy@gmail.com");
        retrieveUser.setTutor(0);
        replaceNullFields(retrieveUser);
        controller.start(2, retrieveUser, new APICallbacks() {
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
            @Override
            public void onFail(@NonNull ResponseBody error){
                System.out.println("FAILURRRRE");
            }
        });
        long newUserPtr = newUser(retrieveUser);
        intent.putExtra("userPointer", newUserPtr);
        startActivity(intent);
    }

    public void signin(String mSignInEmail, String mSignInPassword) {
        User signinUser = new User();
        APIController controller = new APIController();
        Intent intent = new Intent(this, LandingActivity.class);
        signinUser.setEmail(mSignInEmail);
        signinUser.setPassword(mSignInPassword);
        signinUser.setTutor(0);
        controller.start(2, signinUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                testStudentUser = user;
            }
            @Override
            public void onFail(@NonNull ResponseBody error){

            }
        });
        signinUser.setTutor(1);
        controller.start(2, signinUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                testTutorUser = user;
            }
            @Override
            public void onFail(@NonNull ResponseBody error){

            }
        });

        if (testStudentUser == null && testTutorUser == null) {
            Toast.makeText(MainActivity.this, "User does not exist",
                            Toast.LENGTH_LONG).show();
        }
        else {
            controller.start(2, signinUser, new APICallbacks() {
                @Override
                public void onSuccess(@NonNull User user) {
                    if (user.email == signinUser.getEmail() &&
                            user.password == signinUser.getPassword()){
                        signinUser.setName(user.getName());
                        signinUser.setT_courses(user.getT_courses());
                        signinUser.setLocation(user.getLocation());
                        signinUser.setContact(user.getContact());
                        signinUser.setBio(user.getBio());
                        signinUser.setRate(user.getRate());
                        signinUser.setTutor(user.getTutor());
                        signinUser.setPassword(user.getPassword());
                        signinUser.setS_courses(user.getS_courses());
                        signinUser.setStatus(user.getStatus());
                        signinUser.setEmail(user.getEmail());
                        signinUser.setAvailable(user.getAvailable());
                        signinUser.setDuration(user.getDuration());
                        signinUser.setIn_session(user.getIn_session());
                        signinUser.setStars(user.getStars());
                    }

                }
                @Override
                public void onFail(@NonNull ResponseBody error){

                }
            });
            long newUserPtr = newUser(signinUser);
            intent.putExtra("userPointer", newUserPtr);
            startActivity(intent);
        }
    }


    public void signup(String mSignUpEmail, String mSignUpPassword) {
        //User signupUser = new User();
        APIController controller = new APIController();
        Intent intent = new Intent(this, LandingActivity.class);


        testStudentUser.setEmail(mSignUpEmail);
        testStudentUser.setPassword(mSignUpPassword);

        testTutorUser.setEmail(mSignUpEmail);
        testTutorUser.setPassword(mSignUpPassword);
        testTutorUser.setTutor(1);

        retrieveUser.setEmail("kk@gmail.com");
        retrieveUser.setPassword(mSignUpPassword);


        controller.start(0, retrieveUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                if(user.email.equals(mSignUpEmail)){
                    listOfDbUsers.add(user);
                }
                if(listOfDbUsers.size()>0){
                    Toast.makeText(MainActivity.this, "User already exists",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    controller.start(3, retrieveUser, new APICallbacks() {
                        @Override
                        public void onSuccess(@NonNull User user) {
                            System.out.println("USER. new user created");
                            long newUserPtr = newUser(retrieveUser);
                            intent.putExtra("userPointer", newUserPtr);
                            startActivity(intent);
                            }

                            @Override
                            public void onFail(@NonNull ResponseBody error) {
                            System.out.println("USER. failed to create");
                            }
                    });
                }


            }

            @Override
            public void onFail(@NonNull ResponseBody error) {

            }
        });
/*
        controller.start(2, testStudentUser, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                System.out.println("USER.STUDENTFOUND");
                System.out.println("USER."+user.email);
                testStudentUser.setEmail("User exists");
                Toast.makeText(MainActivity.this, "User already exists",
                        Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFail(@NonNull ResponseBody error){
                try{
                System.out.println("USER.STUDENTNOTFOUND"+ error.string());} catch (Exception e){}
                if(!testStudentUser.getEmail().equals("User exists")) {
                    controller.start(2, testTutorUser, new APICallbacks() {
                        @Override
                        public void onSuccess(@NonNull User user) {
                            testTutorUser.setEmail("User exists");
                            System.out.println("USER.TUTORFOUND");

                            Toast.makeText(MainActivity.this, "User already exists",
                                    Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFail(@NonNull ResponseBody error) {
                            System.out.println("USER.TUTORNOTFOUND");
                            if(!testTutorUser.getEmail().equals("User exists")) {
                                controller.start(3, retrieveUser, new APICallbacks() {
                                    @Override
                                    public void onSuccess(@NonNull User user) {
                                        System.out.println("USER. new user created");
                                        long newUserPtr = newUser(retrieveUser);
                                        intent.putExtra("userPointer", newUserPtr);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onFail(@NonNull ResponseBody error) {
                                        System.out.println("USER. failed to create");
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });*/
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
    public native long newUser(User user); //returns C++ pointer to user
}
