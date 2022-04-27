package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textView;
    Spinner spinnerTextOption;

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        spinnerTextOption = findViewById(R.id.spinner1);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioGroup = findViewById(R.id.radioGroup);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rozaNumber, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextOption.setAdapter(adapter);

        // set a listener to check if any of the items in the spinner has changed
        spinnerTextOption.setOnItemSelectedListener(this);

        int answer = Integer.parseInt(spinnerTextOption.getSelectedItem().toString());
//        String answer = spinnerTextOption.getSelectedItem().toString();


        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Sehri/Aftari", Toast.LENGTH_SHORT).show();
        }
        else {
//            // get selected radio button from radioGroup
//            int selectedId = radioGroup.getCheckedRadioButtonId();
//            // find the radiobutton by returned id
//            selectedRadioButton = (RadioButton)findViewById(selectedId);
//
//            if (selectedRadioButton.isChecked()) {
//
//            }

        }

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked && answer == 1) {
                    //Toast.makeText(getApplicationContext(), answer,Toast.LENGTH_LONG).show();
                    textView.setText("04:26 AM");
                }
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked && answer == 1) {
//                    Toast.makeText(getApplicationContext(), radioButton1.getText(),Toast.LENGTH_LONG).show();
                    textView.setText("6:24 PM");
                }
            }
        });


//        if (radioButton1.isChecked() && answer == "1") {
//            textView.setText("04:26 AM");
//        }
//        if (radioButton2.isChecked() && answer.equals("1")) {
//            textView.setText("6:24 PM");
//        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}