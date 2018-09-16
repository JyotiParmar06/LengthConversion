package com.example.yaadvir.project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Converter extends AppCompatActivity {


    Spinner convertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;

    String[] unitTypes = {"centimeters","feet","inches","kilometers","meters","miles","millimeters","yards"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);




            convertFromUnitTypeSpinner = (Spinner)findViewById(R.id.convertFromUnitTypeSpinner);
            convertToUnitTypeSpinner = (Spinner)findViewById(R.id.convertToUnitTypeSpinner);


            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, unitTypes);

            
            convertFromUnitTypeSpinner.setAdapter(spinnerAdapter);
            convertToUnitTypeSpinner.setAdapter(spinnerAdapter);

        }

        public void onClickConvertButtonEvent(View view){


            double beginning_qty;
            double ending_qty;
            String beginning_unit_type;
            String ending_unit_type;

            EditText qtyEditText = (EditText)findViewById(R.id.qtyEditText);
            TextView resultOutputTextView = (TextView)findViewById(R.id.resultOutputTextView);


            Length_Conversion lengthConverter = new Length_Conversion();


            if(!qtyEditText.getText().toString().equals("")) {


                beginning_qty = Double.parseDouble(qtyEditText.getText().toString());
                beginning_unit_type = convertFromUnitTypeSpinner.getSelectedItem().toString();
                ending_unit_type = convertToUnitTypeSpinner.getSelectedItem().toString();
                lengthConverter.setBeginning_qty(beginning_qty);
                lengthConverter.setBeginning_unit_type(beginning_unit_type);
                lengthConverter.setEnding_unit_type(ending_unit_type);
                ending_qty = lengthConverter.calculateEnding_qty();
                lengthConverter.setEnding_qty(ending_qty);
                resultOutputTextView.setText(lengthConverter.toString());

            } else {

                Toast.makeText(getBaseContext(), "Enter Quantity", Toast.LENGTH_SHORT).show();
            }

    }
}
