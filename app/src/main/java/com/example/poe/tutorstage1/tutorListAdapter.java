package com.example.poe.tutorstage1;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import org.w3c.dom.Text;

public class tutorListAdapter extends RecyclerView.Adapter<tutorListAdapter.ViewHolder> {
    private List<tutorListItem> listItems;
    private Context context;

    public tutorListAdapter(List<tutorListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.support_tutor_search, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        tutorListItem listItem = listItems.get(position);

        holder.listItemHead.setText(listItem.getHead());
        holder.tutorDescription.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView listItemHead;
        public TextView tutorDescription;



        public ViewHolder(View itemView) {
            super(itemView);

            listItemHead = (TextView) itemView.findViewById(R.id.listItemHead);
            tutorDescription= (TextView) itemView.findViewById(R.id.tutorDescription);
        }
    }

}
