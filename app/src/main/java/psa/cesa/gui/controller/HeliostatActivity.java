package psa.cesa.gui.controller;

import android.content.Intent;
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

import psa.cesa.gui.R;
import psa.cesa.gui.model.ComLine;
import psa.cesa.gui.view.HeliostatAdapter;

public class HeliostatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HeliostatAdapter heliostatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Toolbar toolbar = findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.heliostatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refresh();
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

    private void refresh() {
        Intent intent = getIntent();
        ComLine comLine = (ComLine) intent.getSerializableExtra("comLine");
        heliostatAdapter = new HeliostatAdapter(this, comLine.getHeliostats());
        recyclerView.setAdapter(heliostatAdapter);
    }
}
