package com.example.viikko9ult;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Spinner spinnerTheaters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        ArrayList<Theater> theatersList = new ArrayList<Theater>();
        Background background = new Background();
        background.readXML(theatersList);

        ArrayList<String> theaterNames = new ArrayList<String>();

        background.createTheaterNameList(theatersList, theaterNames);


        spinnerTheaters = findViewById(R.id.spinnerTheaters);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, theaterNames);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheaters.setAdapter(spinnerAdapter);
    }

    public void testButton (View view) {
        System.out.println("Hommat toimii!");
    }
}
