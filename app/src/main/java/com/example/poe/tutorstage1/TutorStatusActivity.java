package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TutorStatusActivity extends AppCompatActivity {
    User user = new User();
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
        mInactive = findViewById(R.id.buttonInactive);

        if (user.getStatus()==0){
            mActive.setVisibility(View.VISIBLE);
            mInactive.setVisibility(View.INVISIBLE);
        }else{
            mActive.setVisibility(View.INVISIBLE);
            mInactive.setVisibility(View.VISIBLE);
        }


        mActive.setVisibility(View.INVISIBLE);
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
        mStatusSet = findViewById(R.id.setStatusBox);
        mStatusSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                user.setEmail(getEmail(ptr));
                user.setTutor(getTutor(ptr));
                user.setStatus(1);

                APIController controller = new APIController();
                controller.start(4, user, new APICallbacks() {
                    @Override
                    public void onSuccess(@NonNull User user) {
                    }

                });

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
                user.setEmail(getEmail(ptr));
                user.setTutor(getTutor(ptr));
                user.setStatus(0);
                APIController controller = new APIController();
                controller.start(4, user, new APICallbacks() {
                    @Override
                    public void onSuccess(@NonNull User user) {
                    }
                });
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
    public native String getEmail(long ptr);
    public native int getTutor(long ptr);
}
