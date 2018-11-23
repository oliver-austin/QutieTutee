package com.example.poe.tutorstage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TutorListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private tutorListAdapter adapter;
    private List<tutorListItem> listItems;
    List<User> releventUsers = new ArrayList<>();
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private TextView mName;
    private TextView mLocation;
    private TextView mRate;
    private TextView mBio;
    private TextView mContact;
    private RatingBar mStarBar;

    static {
        System.loadLibrary("tutor-list");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_search);
        long ptr = (long)getIntent().getSerializableExtra("userPointer");
        Intent intent = getIntent();
        List<User> allTutors = (List<User>) intent.getSerializableExtra("tutorList");

        String courseSeeking = getStudentCourse(ptr);
        releventUsers = new ArrayList<>();

        for(int i=0; i<allTutors.size(); i++){
            if(allTutors.get(i).getT_courses().equals(courseSeeking)){
                System.out.println("+++Tutor:" + i + " " + allTutors.get(i).email);
                releventUsers.add(allTutors.get(i));
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.tutorList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        //Read in tutors from relevant users
        if(releventUsers.isEmpty()){
            tutorListItem aTutor = new tutorListItem("No tutors available", "nowhere", "$" , true);
        }
        else{
        for(int i = 0; i < releventUsers.size(); i++){
            tutorListItem aTutor = new tutorListItem(releventUsers.get(i).getName(), releventUsers.get(i).getLocation(), "$" + releventUsers.get(i).getRate(), true);
            listItems.add(aTutor);
        }

        adapter = new tutorListAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new tutorListAdapter.OnItemClickListen() {
            @Override
            public void OnItemClick(int position) {
                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.support_tutor_search_popup, null);

                mName = container.findViewById(R.id.popUpName);
                mLocation = container.findViewById(R.id.popUpLocation);
                mRate = container.findViewById(R.id.popUpRate);
                mContact = container.findViewById(R.id.popUpContact);
                mBio = container.findViewById(R.id.popUpBio);
                mStarBar = container.findViewById(R.id.popUpStarBar);

                mName.setText(releventUsers.get(position).getName());
                mLocation.setText(releventUsers.get(position).getLocation());
                mRate.setText("$"+releventUsers.get(position).getRate());
                mContact.setText(releventUsers.get(position).getContact());
                mBio.setText(releventUsers.get(position).getBio());
                mStarBar.setNumStars((int)releventUsers.get(position).getStars());

                popupWindow = new PopupWindow(container, 800, 800, true);
                popupWindow.showAtLocation(recyclerView, Gravity.CENTER, 0, 0);


                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        }); }
    }
    public native String getStudentCourse(long ptr);
}

