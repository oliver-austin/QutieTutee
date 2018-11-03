package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        Button mTutorStatusActivity = (Button)findViewById(R.id.ConfirmButton);
        mTutorStatusActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchTutorStatusActivity(view);
            }
        });
        Button mSwitchToStudentActivity = (Button)findViewById(R.id.SwitchToStudentButton);
        mSwitchToStudentActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switchStudentProfileActivity(view);
            }
        });
    }

    public void switchTutorStatusActivity(View view) {
        Intent intent = new Intent(this, TutorStatusActivity.class);
        startActivity(intent);
    }
    public void switchStudentProfileActivity(View view) {
        Intent intent = new Intent(this, StudentProfileActivity.class);
        startActivity(intent);
    }
}
