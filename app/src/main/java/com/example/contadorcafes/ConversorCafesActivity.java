package com.example.contadorcafes;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConversorCafesActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnMas;
    private Button btnMenos;
    private Button btnComenzar;
    private long minutos;
    private long segundos;
    private TextView txvNumCafe;
    private TextView txvTemp;
    private MyCountDownTimer miContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_cafes);
        btnMas = (Button) findViewById(R.id.btnMas);
        btnMenos = (Button) findViewById(R.id.btnMenos);
        btnComenzar = (Button) findViewById(R.id.btnComenzar);
        txvNumCafe = (TextView) findViewById(R.id.txvNumCafe);
        txvTemp = (TextView) findViewById(R.id.txvTemp);
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnComenzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.btnMas):
                break;
            case (R.id.btnMenos):
                break;
            case (R.id.btnComenzar):
                miContador = new MyCountDownTimer(5 * 60 * 1000, 1000);
                miContador.start();
                break;
        }
    }

    public class MyCountDownTimer extends CountDownTimer{

        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            minutos = (millisUntilFinished / 1000 * 60);
            segundos = (millisUntilFinished / 1000) % 60;
            txvTemp.setText(minutos + ":" + segundos);
        }
        @Override
        public void
        onFinish() {
            miContador = null;
            txvTemp.setText("Pausa terminada!!");
        }
    }
}