package com.example.poe.tutorstage1;

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
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TutorListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private tutorListAdapter adapter;
    private List<tutorListItem> listItems;
    private List<User> allUsers;
    private List<User> releventUsers;
    private User foo = new User();
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;

    static {
        System.loadLibrary("tutor-list");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        APIController controller = new APIController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_search);
        long ptr = (long)getIntent().getSerializableExtra("userPointer");

        controller.start(0, foo, new APICallbacks() {
            @Override
            public void onSuccess(@NonNull User user) {
                allUsers.add(user);
            }
        });

        String courseSeeking = getStudentCourse(ptr);

        for(int i=0; i<allUsers.size(); i++){
            if(allUsers.get(i).getTutor() == 1 && allUsers.get(i).getT_courses().equals(courseSeeking)){
                System.out.println("Enter randy into list");
                releventUsers.add(allUsers.get(i));
            }
        }
//        User temp1 = new User();
//        System.out.println("NAME 1:" + temp1.getName());
//        temp1.setName("Hermoine Granger");
//        System.out.println("NAME 1:" + temp1.getName());
//        temp1.setLocation("Bain");
//        temp1.setRate(14.50);
//
//        User temp2 = new User();
//        temp2.setName("Ron Weasly");
//        temp2.setLocation("ILC 2nd Floor Plaza");
//        temp2.setRate(11.75);
//
//
//        releventUsers = new ArrayList<>();
//        releventUsers.add(temp1);
//        releventUsers.add(temp2);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.tutorList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        System.out.println("USER 1 NAME:" + releventUsers.get(0).getName());
        //HARDCODED VERSION USING C++ CLASS
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
        });
    }
    public native String getStudentCourse(long ptr);
}
