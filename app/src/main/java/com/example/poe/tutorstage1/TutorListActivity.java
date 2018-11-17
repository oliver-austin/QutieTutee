package com.example.poe.tutorstage1;

import android.os.Bundle;
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
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_search);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.tutorList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i= 0; i<10; i++){
            tutorListItem aTutor = new tutorListItem("Tutor Name" + (i+1), "Location", "$ " + (i), true);
            listItems.add(aTutor);
        }

        adapter = new tutorListAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new tutorListAdapter.OnItemClickListen() {
            @Override
            public void OnItemClick(int position) {
                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.support_tutor_search_popup, null);

                popupWindow = new PopupWindow(container, 800, 850, true);
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
}
