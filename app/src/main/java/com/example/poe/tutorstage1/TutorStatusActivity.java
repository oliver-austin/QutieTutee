package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TutorStatusActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }
    private Button mActive;
    private Button mInactive;
    private Button mStatusSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_status);
        long ptr = (long)getIntent().getSerializableExtra("userPointer");

        mActive = findViewById(R.id.buttonActive);
        mActive.setVisibility(View.INVISIBLE);
        mActive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleActive(ptr);
            }

        });

        mInactive = findViewById(R.id.buttonInactive);
        mInactive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toggleInactive(ptr);
            }

        });


    }
    public void toggleActive(long ptr){

        mActive.setVisibility(View.INVISIBLE);
        mInactive.setVisibility(View.VISIBLE);
        mStatusSet = findViewById(R.id.setStatusBox);
        mStatusSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setInactive(ptr);

                int test = getStatus(ptr);
                Toast.makeText(TutorStatusActivity.this, Integer.toString(test),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
    public void toggleInactive(long ptr){

        mActive.setVisibility(View.VISIBLE);
        mInactive.setVisibility(View.INVISIBLE);
        mStatusSet = findViewById(R.id.setStatusBox);
        mStatusSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setActive(ptr);

                int test = getStatus(ptr);
                Toast.makeText(TutorStatusActivity.this, Integer.toString(test),
                        Toast.LENGTH_LONG).show();

            }
        });
    }
    public native void setActive(long ptr);
    public native void setInactive(long ptr);
    public native int getStatus(long ptr);
}
