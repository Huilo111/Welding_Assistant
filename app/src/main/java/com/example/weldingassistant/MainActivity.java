package com.example.weldingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnInfo, btnMenu1, btnGG;
    private LinearLayout choose1;
    private ImageButton image1, image2, image3, image4, image5, image6;
    private Integer ingNumber = 0;
    private EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        axaxa();
    }
    private void init(){
        btnInfo = findViewById(R.id.btnInfo);
        btnMenu1 = findViewById(R.id.btnMenu1);
        choose1 = findViewById(R.id.choose1);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnGG = findViewById(R.id.btnGG);
    }
    private void axaxa(){
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });
        btnMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choose1.getVisibility() == View.GONE) {
                    choose1.setVisibility(View.VISIBLE);
                }else {
                    choose1.setVisibility(View.GONE);
                }
            }
        });
        image1.setOnClickListener(view -> {
            ingNumber = 1;
            choose1.setVisibility(View.GONE);
        });
        image2.setOnClickListener(view -> {
            ingNumber = 2;
            choose1.setVisibility(View.GONE);
        });
        image3.setOnClickListener(view -> {
            ingNumber = 3;
            choose1.setVisibility(View.GONE);
        });
        image4.setOnClickListener(view -> {
            ingNumber = 4;
            choose1.setVisibility(View.GONE);
        });
        image5.setOnClickListener(view -> {
            ingNumber = 5;
            choose1.setVisibility(View.GONE);
        });
        image6.setOnClickListener(view -> {
            ingNumber = 6;
            choose1.setVisibility(View.GONE);
        });
        btnGG.setOnClickListener(view -> {
            search();
        });
    }
    private void search(){
        /*
        ingNumber - номер картинки
        met - толщина мета
         */
        Integer met = Integer.valueOf(editTextNumber.getText().toString());
        if ((ingNumber == 0) || (met == 0)){
            Log.d("GG", "ЕБЛАН");
        }else {
            //ЕБАТЬЬЬЬЬ
            Log.d("GG", "Хороший мальчик");
        }
    }
}