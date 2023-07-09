package com.example.bailab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button btnBai1;
    private Button btnBai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnBai1 = (Button) findViewById(R.id.btnBai1);
        btnBai2 = (Button) findViewById(R.id.btnBai2);
    }
    public  void Bai1 (View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
    public  void Bai2 (View view){
        Intent intent = new Intent(MainActivity2.this,Bai2Lab2.class);
        startActivity(intent);
    }
}