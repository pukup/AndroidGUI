package psa.cesa.gui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.TimerTask;

import psa.cesa.gui.model.ComLine;

public class webServiceTimerTask extends TimerTask {

    private MainActivity mainActivity;
    private HashMap<Integer, ComLine> comLines;

    public webServiceTimerTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        comLines = new HashMap<>();
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
        int comLinesNo = ComLineDAO.getNumber();
        for (int i = 1; i <= comLinesNo; i++) {
            ComLine comLine = ComLineDAO.getAPICache(i);
            comLines.put(comLine.getId(), comLine);
        }
    }
}
