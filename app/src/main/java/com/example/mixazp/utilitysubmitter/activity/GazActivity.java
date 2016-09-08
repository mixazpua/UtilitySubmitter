package com.example.mixazp.utilitysubmitter.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mixazp.utilitysubmitter.DataManager;
import com.example.mixazp.utilitysubmitter.MainActivity;
import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.model.GazDataModel;


public class GazActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaz);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_gaz1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextDate = (EditText) findViewById(R.id.editText_gaz_date);
                EditText editTextUtilites = (EditText) findViewById(R.id.editText_gaz_utilites);
                EditText editTextUtilites2 = (EditText) findViewById(R.id.editText_gaz_utilites2);
                EditText editTextEmail = (EditText) findViewById(R.id.editText_gaz_email);

                GazDataModel item = new GazDataModel();

                item.setDateGaz(editTextDate.getText().toString());
                item.setUtilitesGaz2(editTextUtilites2.getText().toString());
                item.setUtilitesGaz( editTextUtilites.getText().toString());
                item.setEmailGaz(editTextEmail.getText().toString());

                DataManager.getInstance().addGazDataModelItem(view.getContext(),item);
                Intent intent = new Intent(GazActivity.this, MainActivity.class);


                finish();

            }
        });
    }
}