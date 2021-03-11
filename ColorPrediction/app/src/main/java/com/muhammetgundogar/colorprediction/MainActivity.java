package com.muhammetgundogar.colorprediction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttondegistir;
   private Random random;
   private FrameLayout frameLayout;
   private TextView textView;
   private int red;
   private int green;
   private int blue;
   private Snackbar snackbar;
   private View constraintLayout;
   private Button buttonbilgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttondegistir=findViewById(R.id.buttondegistir);
        frameLayout=findViewById(R.id.framelayout);
        Random  random=new Random();
        textView=findViewById(R.id.textView);
        constraintLayout=findViewById(R.id.constrainlayout);
        buttonbilgi=findViewById(R.id.buttonbilgi);
        snackbar.make(constraintLayout,"In this game your friend and you try to guess number of rgb code", 5000)
                .setAction("I see", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                    }
                })
                .show();

        buttondegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setBackgroundColor(Color.rgb(red=random.nextInt(255),green=random.nextInt(255),blue=random.nextInt(255)));
                textView.setText("Color Rgb Code is: "+red+" "+green+" "+blue);
            }
        });

        buttonbilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);

            }
        });

    }



}