package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText firstNameEdt, surnameEdt, iDNoEdt, phoneNoEdt;
    private Button addUserBtn,readUsersBtn,changeDetailsBtn;
    private DatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        firstNameEdt = findViewById(R.id.idEdtFirstName);
        surnameEdt = findViewById(R.id.idEdtSurname);
        iDNoEdt = findViewById(R.id.idEdtIDNo);
        phoneNoEdt = findViewById(R.id.idEdtPhoneNo);
        addUserBtn = findViewById(R.id.idBtnAddUser);
        readUsersBtn = findViewById(R.id.idBtnReadUsers);
        changeDetailsBtn = findViewById(R.id.idBtnChangeDetails);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DatabaseHelper(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String firstName = firstNameEdt.getText().toString();
                String surname = surnameEdt.getText().toString();
                String iDNo =iDNoEdt.getText().toString();
                String phoneNo = phoneNoEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (firstName.isEmpty() && surname.isEmpty() && iDNo.isEmpty() && phoneNo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // user to sqlite data and pass all our values to it.
                dbHandler.addNewUser(firstName, surname, iDNo, phoneNo);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User details added.", Toast.LENGTH_SHORT).show();
                firstNameEdt.setText("");
                surnameEdt.setText("");
                iDNoEdt.setText("");
                phoneNoEdt.setText("");
            }
        });
        readUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewDetails.class);
                startActivity(i);
            }
        });
        changeDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, UpdateDetailsActivity.class);
                startActivity(i);
            }
        });
    }
    }

