package psa.cesa.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComLineAdapter comLineAdapter;
    private HashMap comLines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comLines = new HashMap();
        new WebService(this, comLines).execute();

        recyclerView = findViewById(R.id.comLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comLineAdapter = new ComLineAdapter(this, comLines);
        recyclerView.setAdapter(comLineAdapter);

    }

    public HashMap getList() {
        return comLines;
    }
}
