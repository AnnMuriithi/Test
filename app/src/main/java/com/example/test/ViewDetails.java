package com.example.test;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewDetails extends AppCompatActivity {
    private ArrayList<Usermodal> usermodalArrayList;
    private DatabaseHelper dbHandler;
    private UsersRVAdapter userRVAdapter;
    private RecyclerView usersRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        // initializing our all variables.
        usermodalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHelper(ViewDetails.this);

        // getting our user array
        // list from db handler class.
        usermodalArrayList = dbHandler.readUsers();

        // on below line passing our array list to our adapter class.
        userRVAdapter = new UsersRVAdapter(usermodalArrayList, ViewDetails.this);
        usersRV = findViewById(R.id.idRVUsers);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDetails.this, RecyclerView.VERTICAL, false);
        usersRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        usersRV.setAdapter(userRVAdapter);
    }
}

