package com.example.mixazp.utilitysubmitter.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import com.example.mixazp.utilitysubmitter.DataManager;
import com.example.mixazp.utilitysubmitter.MainActivity;
import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.model.ElectricityDataModel;


public class ElectricityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_electricity1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextDate = (EditText) findViewById(R.id.editText_electricity_date);
                EditText editTextUtilites = (EditText) findViewById(R.id.editText_electricity_utilites);
                EditText editTextUtilites2 = (EditText) findViewById(R.id.editText_electricity_utilites2);
                EditText editTextEmail = (EditText) findViewById(R.id.editText_electricity_email);

                ElectricityDataModel item = new ElectricityDataModel();

                item.setDateElectricity(editTextDate.getText().toString());
                item.setUtilitesElectricity2(editTextUtilites2.getText().toString());
                item.setUtilitesElectricity( editTextUtilites.getText().toString());
                item.setEmailElectricity(editTextEmail.getText().toString());

                DataManager.getInstance().addElectricityDataModelItem(view.getContext(),item);
                Intent intent = new Intent(ElectricityActivity.this, MainActivity.class);

                finish();

            }
        });
    }

}