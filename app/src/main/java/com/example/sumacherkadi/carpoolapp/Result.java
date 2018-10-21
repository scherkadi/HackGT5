package com.example.sumacherkadi.carpoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Result extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle("Carpooling Made Easy!");

        List<Driver> dr = DriverInfo.drivers;
        List<Driver> avDr = DriverInfo.avDrivers;
        Random rand = new Random();
        result = (TextView) findViewById(R.id.result);

        if (avDr.size() != 0) {
            int[] counts = new int[avDr.size()];

            int lowest = 0;

            for (int i = 0; i < avDr.size(); i++) {
                if (i == 0) {
                    counts[i] = avDr.get(i).getDayCount();
                    lowest = counts[0];
                } else {
                    counts[i] = avDr.get(i).getDayCount();
                    if (counts[i] < lowest) {
                        lowest = counts[i];
                    }
                }

            }

            //System.out.println(lowest);
            for (Driver d: avDr) {
                System.out.print(d.getName() + " " + d.getAvailable() + " ");
                System.out.println(d.getDayCount());
            }
            //different length than previous lists
            List<Driver> sameDays = new ArrayList<Driver>();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == lowest) {
                    sameDays.add(avDr.get(i));
                }
            }

            if (sameDays.size() == 1) {
                String show = sameDays.get(0).getName() + " is the driver!";
                result.setText(show);
            } else {
                int num = rand.nextInt(sameDays.size());
                String show = sameDays.get(num).getName() + " is the driver!";
                result.setText(show);
            }

        } else {
            int num = rand.nextInt(dr.size());
            String show = "No driver is free."
                    + " Driver will be randomly assigned.\n"
                    + dr.get(num).getName()
                    + " is the driver!";
            result.setText(show);
        }


    }
}
