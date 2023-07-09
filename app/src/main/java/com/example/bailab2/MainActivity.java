package com.example.bailab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.1.91/kieuthanhtung_ph27675/student_GET.php";
    private EditText edName;
    private EditText edScore;
    private Button btnSend;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.edName);
        edScore = (EditText) findViewById(R.id.edScore);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {    
        String strName, strScore;
        if (view.getId() == R.id.btnSend){
            strName = edName.getText().toString();
            strScore = edScore.getText().toString();

            BackgroundTask_GET backgroundTaskGet = new BackgroundTask_GET(tvResult,strName,strScore,this);
            backgroundTaskGet.execute();
        }
    }
}