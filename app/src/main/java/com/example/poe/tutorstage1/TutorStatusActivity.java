package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TutorStatusActivity extends AppCompatActivity {
    private Button mActive;
    private Button mInactive;
    private Button mStatusSet;
    private Button mSwitchToTutorActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_status);

        mActive = findViewById(R.id.buttonActive);
        mActive.setVisibility(View.INVISIBLE);
        mActive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleActive();
            }

        });

        mInactive = findViewById(R.id.buttonInactive);
        mInactive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleInactive();
            }

        });

        Button mTutorActivity = (Button)findViewById(R.id.EditTutorProfile);
        mTutorActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchTutorProfileActivity(view);
            }
        });

    }
    public void toggleActive(){

        mActive.setVisibility(View.VISIBLE);
        mInactive.setVisibility(View.INVISIBLE);
        mSwitchToTutorActivity.setVisibility(View.INVISIBLE);
        mStatusSet = findViewById(R.id.setStatusBox);
        mStatusSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String userStatus =  "Active";
                //String newStatus = saveProfile(userStatus);
                //Toast.makeText(TutorStatusActivity.this, newStatus,
                  //      Toast.LENGTH_LONG).show();
            }
        });

    }
    public void toggleInactive(){

        mActive.setVisibility(View.INVISIBLE);
        mInactive.setVisibility(View.VISIBLE);
        mSwitchToTutorActivity.setVisibility(View.VISIBLE);
        mStatusSet = findViewById(R.id.setStatusBox);
        mStatusSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String userStatus =  "Inactive";
                //String newStatus = saveProfile(userStatus);
                //Toast.makeText(TutorStatusActivity.this, newStatus,
                  //      Toast.LENGTH_LONG).show();
            }
        });
    }
    public void switchTutorProfileActivity(View view) {
        Intent intent = new Intent(this, TutorProfileActivity.class);
        startActivity(intent);
    }
    //public native String saveProfile(String userStatus);
}
