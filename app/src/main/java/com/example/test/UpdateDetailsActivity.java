package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDetailsActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText firstNameEdt, surnameEdt, iDNoEdt, phoneNoEdt;
    private Button updateDetailsBtn, deleteBtn;
    private DatabaseHelper dbHandler;
    String firstName, surname, iDNo, phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        // initializing all our variables.
        firstNameEdt = findViewById(R.id.idEdtFirstName);
        surnameEdt = findViewById(R.id.idEdtSurname);
        iDNoEdt= findViewById(R.id.idEdtIDNo);
        phoneNoEdt = findViewById(R.id.idEdtPhoneNo);
        updateDetailsBtn = findViewById(R.id.idBtnUpdateDetails);
        deleteBtn = findViewById(R.id.idBtnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DatabaseHelper(UpdateDetailsActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        firstName = getIntent().getStringExtra("firstname");
        surname= getIntent().getStringExtra("surname");
        iDNo= getIntent().getStringExtra("idno");
        phoneNo= getIntent().getStringExtra("phoneno");

        // setting data to edit text
        // of our update activity.
        firstNameEdt.setText(firstName);
        surnameEdt.setText(surname);
        iDNoEdt.setText(iDNo);
        phoneNoEdt.setText(phoneNo);

        // adding on click listener to our update button.
        updateDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update user
                // method and passing all our edit text values.
                dbHandler.updateUser(firstName, firstNameEdt.getText().toString(), surnameEdt.getText().toString(), iDNoEdt.getText().toString(), phoneNoEdt.getText().toString());

                // displaying a toast message that our user details has been updated.
                Toast.makeText(UpdateDetailsActivity.this, "Details Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateDetailsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our user
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our user.
                dbHandler.deleteUser(firstName);
                Toast.makeText(UpdateDetailsActivity.this, "Deleted the Details", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateDetailsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
