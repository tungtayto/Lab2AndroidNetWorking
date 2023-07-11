package com.example.bailab2.Bai3;

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

public class BackgroundTaskBai3_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai3Lab2.LAB2BAI3_LINK;

    Context context;

    String strCanh;

    TextView tvResult;

    ProgressDialog progressDialog;

    String strResult;

    public BackgroundTaskBai3_POST(Context context, String strCanh, TextView tvResult) {
        this.context = context;
        this.strCanh = strCanh;
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
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(duongdan);
            String param  = "canh=" + URLEncoder.encode(strCanh, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content_Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bf.readLine()) != null){
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
