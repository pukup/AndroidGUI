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

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;

import psa.cesa.gui.R;
import psa.cesa.gui.model.ComLine;
import psa.cesa.gui.model.Heliostat;
import psa.cesa.gui.view.ComLineAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComLineAdapter comLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        Timer timer = new Timer("TimerGUIRefresh");
        webServiceTimerTask webServiceTimerTask = new webServiceTimerTask(this);
        timer.schedule(webServiceTimerTask, 0, 10000);

        recyclerView = findViewById(R.id.comLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

    public void refresh(final HashMap comLines) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                comLineAdapter = new ComLineAdapter(getApplicationContext(), comLines);
                recyclerView.setAdapter(comLineAdapter);
            }
        });
    }
}
