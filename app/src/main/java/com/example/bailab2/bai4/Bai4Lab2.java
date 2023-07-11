package com.example.bailab2.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bailab2.R;

public class Bai4Lab2 extends AppCompatActivity implements View.OnClickListener {

    public static final String BAI4_LINK = "http://192.168.1.91/kieuthanhtung_ph27675/ptbac2_POST.php";
    private EditText edA;
    private EditText edB;
    private EditText edC;
    private Button btnSend;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab2);
        edA = (EditText) findViewById(R.id.edA);
        edB = (EditText) findViewById(R.id.edB);
        edC = (EditText) findViewById(R.id.edC);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend){
            BackgroundTaskBai4_POST backgroundTaskBai4_post = new BackgroundTaskBai4_POST(this,edA.getText().toString(),edB.getText().toString(), edC.getText().toString(),tvResult);
            backgroundTaskBai4_post.execute();
        }
    }
}