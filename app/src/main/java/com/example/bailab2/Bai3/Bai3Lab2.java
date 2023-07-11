package com.example.bailab2.Bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bailab2.R;

public class Bai3Lab2 extends AppCompatActivity implements View.OnClickListener {
    private EditText edCanh;
    private Button btnSend;
    private TextView tvResult;

    public static final String LAB2BAI3_LINK = "http://192.168.1.91/kieuthanhtung_ph27675/lapphuong_POST.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab2);
        edCanh = (EditText) findViewById(R.id.edCanh);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend){
            BackgroundTaskBai3_POST backgroundTaskBai3_post = new BackgroundTaskBai3_POST(this,edCanh.getText().toString(),tvResult);
            backgroundTaskBai3_post.execute();
        }
    }
}