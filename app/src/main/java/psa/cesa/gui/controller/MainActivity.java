package psa.cesa.gui.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Timer;

import psa.cesa.gui.R;
import psa.cesa.gui.model.ComLine;
import psa.cesa.gui.model.Heliostat;
import psa.cesa.gui.view.ComLineAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComLineAdapter comLineAdapter;
    private HashMap<Integer, ComLine> comLines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comLines = new HashMap();
        populate(comLines);
        Timer timer = new Timer("TimerGUIRefresh");
//        WebservicetimerCacheTask = new TimerCacheTask(this);
//        timer.schedule(timerCacheTask, 0, 1000);

        recyclerView = findViewById(R.id.comLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refresh(comLines);

    }

    private void populate(HashMap comLines) {
        for (int i = 0; i < 16; i++) {
            ComLine comLine = new ComLine(i+1, createHeliostats(i+1));
            comLines.put(i, comLine);
        }
    }

    private HashMap<Integer, Heliostat> createHeliostats(int comLineId) {
        HashMap<Integer, Heliostat> heliostats = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            heliostats.put(i, new Heliostat(comLineId, i));
        }
        return heliostats;
    }

    public void refresh(HashMap comLines) {
        comLineAdapter = new ComLineAdapter(this, comLines);
        recyclerView.setAdapter(comLineAdapter);
    }
}
