package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    // Used to load the 'native-lib' library on application startup.
    static {
       // System.loadLibrary("native-lib");
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
        //APIController controller = new APIController();
        //controller.start("tutors");
        Intent intent = new Intent(this, LandingActivity.class);
        User user = new User();
        replaceNullFields(user);
        long ptr = newUser(user);
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
        if(user.getPwrd() == null) {
            user.setPwrd("");
        }
        if(user.getBio() == null) {
            user.setBio("");
        }
        if(user.getContact() == null) {
            user.setContact("");
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    public native long newUser(User user);
}
