package com.example.mixazp.utilitysubmitter.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mixazp.utilitysubmitter.DataManager;
import com.example.mixazp.utilitysubmitter.MainActivity;
import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.model.WaterDataModel;


public class WaterActivity extends AppCompatActivity {


    ImageView ivTextCaptcha;
    Button btnTextRefresh;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_water1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextDate = (EditText) findViewById(R.id.editText_water_date);
                EditText editTextUtilites = (EditText) findViewById(R.id.editText_water_utilites);
                EditText editTextUtilites2 = (EditText) findViewById(R.id.editText_water_utilites2);
                EditText editTextEmail = (EditText) findViewById(R.id.editText_water_email);

                WaterDataModel item = new WaterDataModel();

                item.setDate(editTextDate.getText().toString());
                item.setUtilites2(editTextUtilites2.getText().toString());
                item.setUtilites( editTextUtilites.getText().toString());
                item.setEmail(editTextEmail.getText().toString());

                DataManager.getInstance().addWaterDataModelItem(view.getContext(),item);
                Intent intent = new Intent(WaterActivity.this, MainActivity.class);

                finish();

            }
        });
    }

}