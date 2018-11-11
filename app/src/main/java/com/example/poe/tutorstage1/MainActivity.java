package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }
    public void switchLandingActivity(View view) {
        Intent intent = new Intent(this, LandingActivity.class);
        User user = new User();
        intent.putExtra("testClass", user);
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
}
