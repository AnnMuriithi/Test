package com.example.test;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersRVAdapter extends RecyclerView.Adapter<UsersRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Usermodal> usermodalArrayList;
    private Context context;

    // constructor
    public UsersRVAdapter(ArrayList<Usermodal> usermodalArrayList, Context context) {
        this.usermodalArrayList = usermodalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Usermodal modal = usermodalArrayList.get(position);
        holder.firstNameTV.setText(modal.getFirstName());
        holder.surnameTV.setText(modal.getSurname());
        holder.iDNoTV.setText(modal.getIDNo());
        holder.phoneNoTV.setText(modal.getPhoneNo());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateDetailsActivity.class);

                // below we are passing all our values.
                i.putExtra("fname", modal.getFirstName());
                i.putExtra("surname", modal.getSurname());
                i.putExtra("idno", modal.getIDNo());
                i.putExtra("phoneno", modal.getPhoneNo());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return usermodalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView firstNameTV, surnameTV, iDNoTV, phoneNoTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            firstNameTV = itemView.findViewById(R.id.idTVFirstName);
            surnameTV = itemView.findViewById(R.id.idTVSurname);
            iDNoTV = itemView.findViewById(R.id.idTVIDNo);
            phoneNoTV = itemView.findViewById(R.id.idTVPhoneNo);
        }
    }
}