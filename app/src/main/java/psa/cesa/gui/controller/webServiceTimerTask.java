package psa.cesa.gui.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import psa.cesa.gui.model.ComLine;

public class webServiceTimerTask extends TimerTask {

    private MainActivity mainActivity;
    private HashMap<Integer, ComLine> comLines;

    public webServiceTimerTask(MainActivity mainActivity, HashMap comLines) {
        this.mainActivity = mainActivity;
        this.comLines = comLines;
    }

    @Override
    public void run() {
        try {
            getCache();
            mainActivity.refresh(comLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getCache() throws IOException {
        for (Map.Entry<Integer, ComLine> comLineEntry : comLines.entrySet()) {
            ComLine comLine = getAPICache(comLineEntry.getValue().getId());
            comLines.put(comLine.getId(), comLine);
        }
    }

    private ComLine getAPICache(int i) throws IOException {
        String s = getAPIString("https://localhost:8080/getCache?comLineId=" + i);
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
