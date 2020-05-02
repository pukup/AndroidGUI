package psa.cesa.gui;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class WebService extends AsyncTask<Void, Void, String> {

    private MainActivity mainActivity;
    private HashMap comLines;

    WebService(MainActivity mainActivity, HashMap comLines) {
        this.mainActivity = mainActivity;
        this.comLines = comLines;
    }

    @Override
    public String doInBackground(Void... voids) {
        while(true) {
            for (int i = 1; i < 16; i++) {
                try {
                    ComLine comLine = getAPICache("http://localhost:8080/getCache?comLineId=" + i);
                    comLines.put(i, comLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainActivity.getList();
        }
    }

    private ComLine getAPICache(String url) throws IOException {
        String s = getAPIString(url);
        Gson gson = new Gson();
        return gson.fromJson(s, ComLine.class);
    }

    private String getAPIString(String url) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URLConnection urlConnection = new URL(url).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        char[] chars = new char[1024];
        int readedChar;
        while ((readedChar = inputStreamReader.read(chars, 0, chars.length)) > 0) {
            stringBuilder.append(chars, 0, readedChar);
        }
        inputStreamReader.close();
        return stringBuilder.toString();
    }
}
