package psa.cesa.gui.controller;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        Toolbar toolbar = findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        comLines = new HashMap();
        populate(comLines);
        Timer timer = new Timer("TimerGUIRefresh");
        webServiceTimerTask webServiceTimerTask = new webServiceTimerTask(this, comLines);
        timer.schedule(webServiceTimerTask, 0, 1000);

        recyclerView = findViewById(R.id.comLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refresh(comLines);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        return super.onOptionsItemSelected(item);
    }

    private void populate(HashMap comLines) {
        for (int i = 0; i < 16; i++) {
            ComLine comLine = new ComLine(i + 1, createHeliostats(i + 1));
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
