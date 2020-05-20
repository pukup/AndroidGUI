package psa.cesa.gui.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import psa.cesa.gui.model.ComLine;

public class ComLineDAO {

    public static ComLine getAPICache(int i) throws IOException {
        String s = getAPIString("http://10.0.2.2:8080/getCache?comLineId=" + i);
        Gson gson = new Gson();
        return gson.fromJson(s, ComLine.class);
    }

    public static int getNumber() throws IOException {
        String s = getAPIString("http://10.0.2.2:8080/getNumber");
        Gson gson = new Gson();
        return gson.fromJson(s, Integer.class);
    }

    private static String getAPIString(String url) throws IOException {
        java.lang.System.setProperty("https.protocols", "TLSv1");
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
