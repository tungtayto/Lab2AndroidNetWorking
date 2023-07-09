package com.example.bailab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackdroundTask_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai2Lab2.LAB2_LINK;
    Context context;
    String strWith, strLength;
    TextView tvResult;
    ProgressDialog progressDialog;
    String strResult;

    public BackdroundTask_POST(Context context, String strWith, String strLength, TextView tvResult) {
        this.context = context;
        this.strWith = strWith;
        this.strLength = strLength;
        this.tvResult = tvResult;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Caculating...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL(duongdan);
            String param = "rong="+ URLEncoder.encode(strWith, "utf-8") + "&dai=" +URLEncoder.encode(strLength, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            strResult = sb.toString();
            urlConnection.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }

        tvResult.setText(strResult);
    }
}
