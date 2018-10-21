package com.example.sumacherkadi.carpoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DriverInfo extends AppCompatActivity {

    static List<Driver> drivers = new ArrayList<Driver>();
    static List<Driver> avDrivers = new ArrayList<Driver>();
    TextView driverName, nameTxt, availableTxt,  yesTxt, noTxt, daysDrivenTxt;
    EditText nameInput, daysInput;
    Switch toggle;
    Button addDriver;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);
        getSupportActionBar().setTitle("Carpooling Made Easy!");
        driverName = (TextView) findViewById(R.id.driverName);
        nameTxt = (TextView) findViewById(R.id.nameTxt);
        availableTxt = (TextView) findViewById(R.id.availableTxt);
        yesTxt = (TextView) findViewById(R.id.yesTxt);
        noTxt = (TextView) findViewById(R.id.noTxt);
        daysDrivenTxt = (TextView) findViewById(R.id.daysDrivenTxt);

        nameInput = (EditText) findViewById(R.id.nameInput);
        daysInput = (EditText) findViewById(R.id.daysInput);
        toggle = (Switch) findViewById(R.id.toggle);
        configDriverButton();
        configNextButton();
    }


    private void configDriverButton() {
        addDriver = (Button) findViewById(R.id.addDriver);
        addDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                drivers.add(new Driver(name, !toggle.isChecked(),
                        Integer.parseInt(daysInput.getText().toString())));
                if (!toggle.isChecked()) {
                    System.out.println(name + " " + !toggle.isChecked());
                    avDrivers.add(new Driver(name, !toggle.isChecked(),
                            Integer.parseInt(daysInput.getText().toString())));
                }
                nameInput.setText("");
                toggle.setChecked(false);
                daysInput.setText("");
            }
        });
    }
    private void configNextButton() {
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverInfo.this, Result.class));
            }
        });
    }
}
