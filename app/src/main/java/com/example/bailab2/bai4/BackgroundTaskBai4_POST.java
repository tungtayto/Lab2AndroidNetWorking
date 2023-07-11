package com.example.bailab2.bai4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.bailab2.Bai2.Bai2Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTaskBai4_POST extends AsyncTask<Void, Void, Void> {

    String duongdan = Bai4Lab2.BAI4_LINK;

    Context context;

    String strA, strB, strC;

    TextView tvResult;

    ProgressDialog progressDialog;

    String strResult;

    public BackgroundTaskBai4_POST(Context context, String strA, String strB, String strC, TextView tvResult) {
        this.context = context;
        this.strA = strA;
        this.strB = strB;
        this.strC = strC;
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
            String param = "a="+ URLEncoder.encode(strA, "utf-8")
                    + "&b=" +URLEncoder.encode(strB, "utf-8")
                    + "&c=" +URLEncoder.encode(strC, "utf-8");
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
