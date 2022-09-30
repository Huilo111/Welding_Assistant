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
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnInfo, btnMenu1, btnMenu2, btnMenu3, btnGG;
    private LinearLayout choose1,choose2, choose3;
    private RadioButton radioButton1, radioButton2, radioButton3,radioButton4,radioButton5,radioButton6,radioButton7,radioButton8,radioButton9;
    private Integer Polozenie = 0;
    private Integer Metaltip = 0;
    private Integer Elektrod = 0;
    private int I;
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
        btnMenu2 = findViewById(R.id.btnMenu2);
        btnMenu3 = findViewById(R.id.btnMenu3);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);
        radioButton8 = findViewById(R.id.radioButton8);
        radioButton9 = findViewById(R.id.radioButton9);
        choose1 = findViewById(R.id.choose1);
        choose2 = findViewById(R.id.choose2);
        choose3 = findViewById(R.id.choose3);
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
        radioButton1.setOnClickListener(view -> {
            Polozenie = 1;
            choose1.setVisibility(View.GONE);
        });
        radioButton2.setOnClickListener(view -> {
            Polozenie = 2;
            choose1.setVisibility(View.GONE);
        });
        radioButton3.setOnClickListener(view -> {
            Polozenie = 3;
            choose1.setVisibility(View.GONE);
        });
        btnMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choose2.getVisibility() == View.GONE) {
                    choose2.setVisibility(View.VISIBLE);
                }else {
                    choose2.setVisibility(View.GONE);
                }
            }
        });
        /*
        Тип металла влияет только на полярнось
        если выбран ПЕРВЫЙ тип металла, то ПОЛЯРНОСТЬ ПРЯМАЯ
        если выбран ВТОРОЙ тип металла, то ПОЛЯРНОСТЬ ОБРАТНАЯ
         */
        radioButton4.setOnClickListener(view -> {
            Metaltip = 1;
            choose2.setVisibility(View.GONE);
        });
        radioButton5.setOnClickListener(view -> {
            Metaltip = 2;
            choose2.setVisibility(View.GONE);
        });
        btnMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choose3.getVisibility() == View.GONE) {
                    choose3.setVisibility(View.VISIBLE);
                }else {
                    choose3.setVisibility(View.GONE);
                }
            }
        });
        radioButton6.setOnClickListener(view -> {
            Elektrod = 1;
            choose3.setVisibility(View.GONE);
        });
        radioButton7.setOnClickListener(view -> {
            Elektrod = 2;
            choose3.setVisibility(View.GONE);
        });
        radioButton8.setOnClickListener(view -> {
            Elektrod = 3;
            choose3.setVisibility(View.GONE);
        });
        radioButton9.setOnClickListener(view -> {
            Elektrod = 4;
            choose3.setVisibility(View.GONE);
        });


        btnGG.setOnClickListener(view -> {
            search();
        });

    }
    private void search(){
        /*
        Polozenie - номер положения сварки
        Elektrod - диаметр электрода
        Metaltip - тип металла
        met - толщина мета
        I - конечный расчёт силы тока
        При диаметре электрода 2мм - толщина металла от 1.5 до 2 мм
        При диаметре электрода 2.5мм - толщина металла от 2 до 3 мм
        При диаметре электрода 3мм - толщина металла от 3 до 4 мм
        При диаметре электрода 4мм - толщина металла от 4 до 10 мм
         */
        double met = Integer.valueOf(editTextNumber.getText().toString());
        if ((Polozenie == 0) || (met == 0)){
            Log.d("GG", "ЕБЛАН");
        }else {
            //ЕБАТЬЬЬЬЬ
            Log.d("GG", "Хороший мальчик");
            if (Polozenie == 1){
                if ((Elektrod == 1) && (met >=1.5) && (met <= 2)){
                    I = 40 * (met - 0.5);
                }
                else if ((Elektrod == 2) && (met >=2) && (met <= 3)){
                    if (met < 3){
                        I = 60+ ((met % 10) * 2);
                    }
                    else{
                        I = 80;
                    }
                }
                else if ((Elektrod == 3) && (met >= 3) && (met <= 4)){
                    if (met < 4){
                        I = 80 + ((met % 10) * 8);
                    }
                    else{
                        I = 160;
                    }
                }
                else if ((Elektrod == 4) && (met >= 4) && (met <= 10)){
                    I = 120 + (18 * (met - 4));
                }
            }
            /*
        ПРИ ПОЛОЖЕНИИ 2 ИЗ I ВЫЧИТАЕМ 10 ПРОЦЕНТОВ
         */
            else if (Polozenie == 2){
                if ((Elektrod == 1) && (met >=1.5) && (met <= 2)){
                    I = 40 * (met - 0.5);
                    I = I - (I / 10);
                }
                else if ((Elektrod == 2) && (met >=2) && (met <= 3)){
                    if (met < 3){
                        I = 60+ ((met % 10) * 2);
                        I = I - (I / 10);
                    }
                    else{
                        I = 72;
                    }
                }
                else if ((Elektrod == 3) && (met >= 3) && (met <= 4)){
                    if (met < 4){
                        I = 80 + ((met % 10) * 8);
                        I = I - (I / 10);
                    }
                    else{
                        I = 144;
                    }
                }
                else if ((Elektrod == 4) && (met >= 4) && (met <= 10)){
                    I = 120 + (18 * (met - 4));
                    I = I - (I / 10);
                }

            }
            /*
        ПРИ ПОЛОЖЕНИИ 3 ИЗ I ВЫЧИТАЕМ 20 ПРОЦЕНТОВ
         */
            else if (Polozenie == 3){
                if ((Elektrod == 1) && (met >=1.5) && (met <= 2)){
                    I = 40 * (met - 0.5);
                    I = I - (I / 20);
                }
                else if ((Elektrod == 2) && (met >=2) && (met <= 3)){
                    if (met < 3){
                        I = 60+ ((met % 10) * 2);
                        I = I - (I / 20);
                    }
                    else{
                        I = 64;
                    }
                }
                else if ((Elektrod == 3) && (met >= 3) && (met <= 4)){
                    if (met < 4){
                        I = 80 + ((met % 10) * 8);
                        I = I - (I / 20);
                    }
                    else{
                        I = 128;
                    }
                }
                else if ((Elektrod == 4) && (met >= 4) && (met <= 10)){
                    I = 120 + (18 * (met - 4));
                    I = I - (I / 20);
                }
        }

    }

}

