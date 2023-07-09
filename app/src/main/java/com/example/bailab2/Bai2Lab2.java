package com.example.bailab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2Lab2 extends AppCompatActivity implements View.OnClickListener {
    public static final String LAB2_LINK = "http://192.168.1.91/kieuthanhtung_ph27675/dientich_POST.php";
    private EditText edRong;
    private EditText edDai;
    private Button btnSend;
    private TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab2);

        edDai = (EditText) findViewById(R.id.edDai);
        edRong = (EditText) findViewById(R.id.edRong);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend){
            BackdroundTask_POST backdroundTask_post = new BackdroundTask_POST(this,edRong.getText().toString(),edDai.getText().toString(),tvResult);
            backdroundTask_post.execute();
        }
    }
}