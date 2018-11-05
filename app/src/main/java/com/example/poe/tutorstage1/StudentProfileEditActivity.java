package com.example.poe.tutorstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentProfileEditActivity extends AppCompatActivity {

    //Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile_edit);

        final EditText mUserName = (EditText)findViewById(R.id.userName);
        Button mSave = (Button)findViewById(R.id.saveProfile);
        mSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userName =  mUserName.getText().toString();
                String newUserName = saveProfile(userName);
                //Send to database
                Toast.makeText(StudentProfileEditActivity.this, newUserName,
                        Toast.LENGTH_LONG).show();
            }
        });
    }



    public native String saveProfile(String userName);

}
